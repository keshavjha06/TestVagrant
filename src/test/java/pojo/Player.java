package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Player {
    private String name;
    private String country;
    private String role;
    @JsonProperty("price-in-crores")
    private String priceInCrores;
}