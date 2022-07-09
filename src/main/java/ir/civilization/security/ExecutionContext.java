package ir.civilization.security;

import ir.civilization.model.Civilization;
import ir.civilization.model.user.User;
import lombok.Data;

@Data
public class ExecutionContext {

    private User user;
    private Civilization civilization;

}
