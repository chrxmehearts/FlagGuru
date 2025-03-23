package ivanevilcorp.flagguru.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
    @RequestMapping({"/", "", "/flag-guru", "/flag-guru/"})
    public String redirectToWelcomePage(){
        return "redirect:/game.html";
    }
}
