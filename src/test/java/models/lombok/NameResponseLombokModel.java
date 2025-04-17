package models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NameResponseLombokModel {
    private String name;
    private String job;
    private String id;
    private String createAt;
}
