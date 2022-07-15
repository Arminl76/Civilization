package ir.civilization.dao;

import ir.civilization.model.City;
import ir.civilization.model.Tile;
import ir.civilization.model.map.Map;

public class CityDao {

    public static final CityDao INSTANCE = new CityDao();

    private CityDao() {}

    public City findCityByName(String name, Map map) {
        return map.getMapAsSet()
                .stream()
                .map(Tile::getOccupant)
                .filter(mo -> mo instanceof City)
                .map(mo -> (City) mo)
                .filter(c -> name.equalsIgnoreCase(c.getName()))
                .findAny()
                .orElse(null);
    }

}
