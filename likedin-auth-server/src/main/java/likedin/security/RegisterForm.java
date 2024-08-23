package likedin.security;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import likedin.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@NoArgsConstructor
public class RegisterForm {
  @NonNull
  @NotBlank
  @Email(message = "incorrect email format")
  private String email;

  @NonNull
  @NotBlank(message = "incorrect password format")
  private String password;

  @NonNull
  @NotBlank(message = "incorrect name format")
  private String name;

  @NonNull
  @NotBlank(message = "incorrect surname format")
  private String surname;

  public User toUser(PasswordEncoder passwordEncoder) {
    return new User(email, passwordEncoder.encode(password), name, surname, "ROLE_USER");
  }
}
