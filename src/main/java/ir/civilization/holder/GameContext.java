package ir.civilization.holder;

import ir.civilization.model.unit.Unit;
import lombok.Data;

@Data
public class GameContext {

    private Unit activeUnit;
    private int mp = 0;

    public void increaseMp(int amount) {
        mp += amount;
    }

    public void decreaseMp(int amount) {
        mp -= amount;
    }

}
