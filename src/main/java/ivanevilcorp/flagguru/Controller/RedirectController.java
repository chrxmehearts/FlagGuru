package ivanevilcorp.flagguru.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
    @RequestMapping("/")
    public String redirectToWelcomePage(){
        return "redirect:/flag-guru/welcome";
    }
}
