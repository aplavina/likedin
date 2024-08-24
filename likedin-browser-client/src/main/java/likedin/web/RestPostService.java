package likedin.web;

import java.io.IOException;
import java.util.Arrays;
import likedin.Post;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

public class RestPostService implements PostService {
  private RestTemplate restTemplate;

  public RestPostService(String accessToken) {
    this.restTemplate = new RestTemplate();
    if (accessToken != null) {
      this.restTemplate.getInterceptors().add(getBearerTokenInterceptor(accessToken));
    }
  }

  private ClientHttpRequestInterceptor getBearerTokenInterceptor(String accessToken) {
    return new ClientHttpRequestInterceptor() {
      @Override
      public ClientHttpResponse intercept(
          HttpRequest request, byte[] bytes, ClientHttpRequestExecution execution)
          throws IOException {
        request.getHeaders().add("Authorization", "Bearer " + accessToken);
        return execution.execute(request, bytes);
      }
    };
  }

  @Override
  public Iterable<Post> findRecent() {
    return Arrays.asList(restTemplate.getForObject("http://localhost:7000/api/posts", Post[].class));
  }
}
