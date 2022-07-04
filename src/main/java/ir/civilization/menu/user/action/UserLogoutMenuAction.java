package ir.civilization.menu.user.action;


import ir.civilization.dao.UserDao;
import ir.civilization.dto.UserDTO;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.user.User;
import ir.civilization.security.AuthenticatedUserHolder;

import java.util.Optional;

public class UserLogoutMenuAction extends AbstractMenuAction<UserDTO> {

    public static final UserLogoutMenuAction INSTANCE = new UserLogoutMenuAction();

    private final UserDao userDao = UserDao.INSTANCE;
    private final AuthenticatedUserHolder authenticatedUserHolder = AuthenticatedUserHolder.INSTANCE;

    private UserLogoutMenuAction() {
    }

    @Override
    public Class<UserDTO> getDtoClazz() {
        return UserDTO.class;
    }

    @Override
    public void takeAction(UserDTO userDTO) {
        Optional<User> user = userDao.findByUsername(userDTO.getUsername());
        if (user.isPresent()) {
            authenticatedUserHolder.removePrinciple();
            System.out.println("user logged out successfully!");
        } else
            System.out.println("no authenticated user founded!");
    }

}
