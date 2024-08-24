package likedin.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
  private final PostService postService;

  @GetMapping
  public String homePage(Model model) {
    model.addAttribute("posts", postService.findRecent());
    return "home";
  }
}
