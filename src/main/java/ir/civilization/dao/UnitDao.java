package ir.civilization.dao;

public class UnitDao {

    public static final UnitDao INSTANCE = new UnitDao();

//    public Collection<Unit> getUnitsByCivilization(Civilization civilization) {
//        return civilization.getTiles()
//                .stream()
//                .map(Tile::getUnits)
//                .flatMap(Collection::stream)
//                .collect(Collectors.toSet());
//    }
//
//    public Collection<Unit> getUnitsByTile(Tile tile) {
//        return tile.getUnits();
//    }

}
