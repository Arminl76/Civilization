package ir.civilization.menu;


import ir.civilization.dao.UserDao;
import ir.civilization.dto.UserDTO;
import ir.civilization.model.user.User;

public class UserCreationMenuAction extends AbstractMenuAction<UserDTO> {

    public static final UserCreationMenuAction INSTANCE = new UserCreationMenuAction();

    @Override
    public Class<UserDTO> getDtoClazz() {
        return UserDTO.class;
    }

    @Override
    public void takeAction(UserDTO userDTO) {
        User user = userDTO.getSaved();
        UserDao.INSTANCE.save(user);
    }

}
