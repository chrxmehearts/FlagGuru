package ivanevilcorp.flagguru.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class GameQuestion {
    private String flagURL;
    private List<String> options;
    private String correctOption;
}
