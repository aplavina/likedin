package likedin.security;

import jakarta.validation.Valid;
import likedin.data.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class RegisterController {

  private final UserRepository userRepo;
  private final PasswordEncoder encoder;

  @Autowired
  public RegisterController(UserRepository userRepo, PasswordEncoder encoder) {
    this.userRepo = userRepo;
    this.encoder = encoder;
  }

  @GetMapping("/register")
  public String registerView() {
    return "register";
  }

  @ModelAttribute(name = "registerForm")
  public RegisterForm order() {
    return new RegisterForm();
  }

  @PostMapping("/register")
  public String pricessRegisterForm(@Valid @ModelAttribute RegisterForm form, Errors errors) {
    if (errors.hasErrors()) {
      return "register";
    }

    userRepo.save(form.toUser(encoder));
    return "redirect:/login";
  }
}
