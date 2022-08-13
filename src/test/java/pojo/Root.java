package pojo;


import lombok.Data;

import java.util.ArrayList;

@Data
public class Root {

    private String name;
    private String location;
    private ArrayList<Player> player;

}
