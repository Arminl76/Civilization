package ir.civilization.model;

import ir.civilization.model.map.MapObject;

public class City extends MapObject {

    private String name;
    private char symbol;

    public City(Civilization owner) {
        super(owner);
    }

    @Override
    public char symbol() {
        return this.getOwner().getSymbol();
    }
}
