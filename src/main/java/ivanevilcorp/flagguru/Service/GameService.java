package ivanevilcorp.flagguru.Service;

import ivanevilcorp.flagguru.Entity.Country;
import ivanevilcorp.flagguru.Model.GameQuestion;
import ivanevilcorp.flagguru.Repository.CountryRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class GameService {
    private final CountryRepo countryRepo;
    private final Random random = new Random();
    public GameService(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public GameQuestion startGame(){
        List<Country> allCountries = countryRepo.findAll();
        List<Country> notUsedCountries = new ArrayList<>(allCountries);
        Country correctCountry = allCountries.get(random.nextInt(allCountries.size()));
        notUsedCountries.remove(correctCountry);
        List<String> options = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Country randomCountry = notUsedCountries.get(random.nextInt(notUsedCountries.size()));
            options.add(randomCountry.getName());
            notUsedCountries.remove(randomCountry);
        }
        options.add(correctCountry.getName());
        Collections.shuffle(options);
        GameQuestion gameQuestion = new GameQuestion();
        gameQuestion.setFlagURL(correctCountry.getFlag());
        gameQuestion.setOptions(options);
        gameQuestion.setCorrectOption(correctCountry.getName());
        return gameQuestion;
    }

    public String checkAnswer(GameQuestion gameQuestion, String answer){
        System.out.println("Answer: " + answer + "correct: " + gameQuestion.getCorrectOption());
        if(gameQuestion.getCorrectOption().equals(answer)){
            return "Correct!";
        } else {
            return "Wrong!";
        }
    }
}
