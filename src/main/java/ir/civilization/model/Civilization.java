package ir.civilization.model;

import ir.civilization.model.technology.Technology;
import ir.civilization.model.user.User;
import lombok.Data;

import java.util.List;

@Data
public class Civilization {


    private String name;
    private String symbol;

    private Technology technology = new Technology();

    private int numSettlements;

    private Treasury treasury = new Treasury(50);
    private int food = 50;
    private int resources = 50;
    private int happiness = 50;

    private User user;
    private List<Tile> tiles;

}
