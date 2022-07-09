package ir.civilization.menu.info.action;


import ir.civilization.dao.UnitDao;
import ir.civilization.dto.EmptyCmdLoader;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.security.AuthenticatedUserHolder;

public class UnitsInfoMenuAction extends AbstractMenuAction<EmptyCmdLoader> {

    public static final UnitsInfoMenuAction INSTANCE = new UnitsInfoMenuAction();

    private final UnitDao unitDao = UnitDao.INSTANCE;
    private final AuthenticatedUserHolder authHolder = AuthenticatedUserHolder.INSTANCE;

    private UnitsInfoMenuAction() {
    }

    @Override
    public Class<EmptyCmdLoader> getDtoClazz() {
        return EmptyCmdLoader.class;
    }

    @Override
    public void takeAction(EmptyCmdLoader v) {
//        Civilization civilization = authHolder.getCurrentExecutionContext().getCivilization();
//        String json = JacksonUtils.getJsonFromObject(
//                DtoUtils.createAndLoadList(
//                        unitDao.getUnitsByCivilization(civilization),
//                        UnitResponseDTO::new
//                )
//        );
//        System.out.println(json);
    }

}
