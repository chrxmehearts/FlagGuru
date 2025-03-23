package ivanevilcorp.flagguru.Service;

import ivanevilcorp.flagguru.Entity.Country;
import ivanevilcorp.flagguru.Repository.CountryRepo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    private final CountryRepo countryRepo;
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_COUNTRY_URL = UriComponentsBuilder.fromHttpUrl("https://restcountries.com/v3.1/all")
            .queryParam("fields", "name,flags,cca2")
            .toUriString();

    public CountryService(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public void fetchAndSaveCountries() {
        if (countryRepo.count() > 0) {
            System.out.println("Countries already added");
            return;
        }


        String response = restTemplate.getForObject(API_COUNTRY_URL, String.class);
        JSONArray countryArray = new JSONArray(response);
        List<Country> countryList = new ArrayList<>();

        for (int i = 0; i < countryArray.length(); i++) {
            JSONObject countryObj = countryArray.getJSONObject(i);
            String name = countryObj.getJSONObject("name").getString("common");
            String code = countryObj.getString("cca2");
            String flagURL = countryObj.getJSONObject("flags").getString("png");

            Country country = new Country();
            country.setName(name);
            country.setCode(code);
            country.setFlag(flagURL);
            countryList.add(country);
        }
        countryRepo.saveAll(countryList);
        System.out.println("Added " + countryList.size() + " countries to DB");
    }

}
