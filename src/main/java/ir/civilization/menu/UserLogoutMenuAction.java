package ir.civilization.menu;


import ir.civilization.dao.UserDao;
import ir.civilization.dto.UserDTO;
import ir.civilization.holder.AuthenticatedUserHolder;
import ir.civilization.model.user.User;

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
            authenticatedUserHolder.remove(user.get());
            System.out.println("user logged out successfully!");
        } else
            System.out.println("no authenticated user founded!");
    }

}
