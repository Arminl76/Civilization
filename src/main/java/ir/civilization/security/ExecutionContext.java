package ir.civilization.security;

import ir.civilization.model.Civilization;
import ir.civilization.model.unit.UnitAction;
import ir.civilization.model.user.User;
import lombok.Data;

import java.util.List;

@Data
public class ExecutionContext {

    private User user;
    private Civilization civilization;
    private List<UnitAction> unitActions;

}
