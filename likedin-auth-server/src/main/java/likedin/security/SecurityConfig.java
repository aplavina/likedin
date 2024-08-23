package likedin.security;

import likedin.data.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            authorize ->
                authorize
                    .requestMatchers("/register/**", "error")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .formLogin(
            formLogin -> formLogin.loginPage("/login").permitAll().loginProcessingUrl("/login"));

    return http.build();
  }

  @Bean
  public UserDetailsService customUserDetailsService(UserRepository userRepo) {
    return email -> userRepo.findByEmail(email);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
