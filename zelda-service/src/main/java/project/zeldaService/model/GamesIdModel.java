package project.zeldaService.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GamesIdModel {

    private Boolean success;
    private Integer count;
    private ZeldaModel Data;

}
