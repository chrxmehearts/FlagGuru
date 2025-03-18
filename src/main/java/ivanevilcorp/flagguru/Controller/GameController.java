package ivanevilcorp.flagguru.Controller;

import ivanevilcorp.flagguru.Entity.Country;
import ivanevilcorp.flagguru.Service.CountryService;
import ivanevilcorp.flagguru.Service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/flag-guru")
public class GameController {
    private final GameService gameService;
    private final CountryService countryService;

    public GameController(GameService gameService, CountryService countryService) {
        this.gameService = gameService;
        this.countryService = countryService;
    }
    @GetMapping("/welcome")
    public ResponseEntity<String> welcomePage(){
        return ResponseEntity.ok("Welcome to Flag Guru!");
    }


}
