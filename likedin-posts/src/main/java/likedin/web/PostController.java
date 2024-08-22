package likedin.web;

import java.util.List;
import likedin.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/posts", produces = "application/json")
public class PostController {
  @GetMapping
  public List<Post> getPosts() {
    List<Post> testData = List.of(new Post("Post 1 text"), new Post("Post 2 text"));
    return testData;
  }
}
