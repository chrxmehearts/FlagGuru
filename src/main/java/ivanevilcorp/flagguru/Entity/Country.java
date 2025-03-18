package ivanevilcorp.flagguru.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "country")
@Data
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false, length = 5)
    private String code;
    @Column(nullable = false)
    private String flag;
}
