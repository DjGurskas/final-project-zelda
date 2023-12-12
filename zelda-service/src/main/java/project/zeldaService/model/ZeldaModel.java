package project.zeldaService.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ZeldaModel {

    private String name;
    private String description;
    private String developer;
    private String publisher;
    private String released_date;
    private String id;

}
