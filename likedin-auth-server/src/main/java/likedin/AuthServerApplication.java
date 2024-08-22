package likedin;

import likedin.data.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthServerApplication.class, args);
  }

  @Bean
  public ApplicationRunner dataLoader(UserRepository repo, PasswordEncoder encoder) {
    return args -> {
      repo.save(new User("user1@mail.com", encoder.encode("1234"), "ROLE_USER"));
      repo.save(new User("user2@mail.com", encoder.encode("1234"), "ROLE_USER"));
    };
  }
}
