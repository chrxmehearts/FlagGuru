package ivanevilcorp.flagguru;

import ivanevilcorp.flagguru.Service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CountryService countryService;

    public DataInitializer(CountryService countryService) {
        this.countryService = countryService;
    }
    @Override
    public void run(String... args) throws Exception {
     countryService.fetchAndSaveCountries();
    }
}
