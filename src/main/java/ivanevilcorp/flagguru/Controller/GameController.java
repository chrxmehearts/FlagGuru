package ivanevilcorp.flagguru.Controller;

import ivanevilcorp.flagguru.Model.GameQuestion;
import ivanevilcorp.flagguru.Service.CountryService;
import ivanevilcorp.flagguru.Service.GameService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> welcomePage() {
        return ResponseEntity.ok("Welcome to Flag Guru!");
    }

    @GetMapping("/game")
    public ResponseEntity<GameQuestion> gamePage(HttpSession session) {
        GameQuestion gameQuestion = gameService.startGame();
        session.setAttribute("gameQuestion", gameQuestion);
        return ResponseEntity.ok(gameQuestion);
    }

    @PostMapping("/game")
    public ResponseEntity<String> checkAnswer(@RequestBody String answer, HttpSession session) {
        GameQuestion gameQuestion = (GameQuestion) session.getAttribute("gameQuestion");
        String result = gameService.checkAnswer(gameQuestion, answer);
        return ResponseEntity.ok(result);
    }


}
