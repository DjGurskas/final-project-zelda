package project.zeldaService.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import java.util.List;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GamesModel {

    private Boolean success;
    private List<ZeldaModel> Data;

}
