package ivanevilcorp.flagguru.Repository;

import ivanevilcorp.flagguru.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Integer> {
    public Country findByName(String name);
    public Country findByCode(String code);
}
