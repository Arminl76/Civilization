package ir.civilization.validator;

import ir.civilization.dto.UserDTO;
import ir.civilization.exception.NicknameAlreadyExistException;
import ir.civilization.exception.UsernameAlreadyExistException;
import ir.civilization.holder.UserHolder;
import ir.civilization.model.user.User;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

public final class UserValidator {

    public static void validateUserAddition(UserDTO userDTO) {
        Collection<User> users = UserHolder.INSTANCE.getAll();

        for (User user : users) {
            // validate username
            String username = userDTO.getUsername();
            if (StringUtils.isBlank(username))
                throw new IllegalArgumentException("username cannot be null!");
            if (username.equals(user.getUsername()))
                throw new UsernameAlreadyExistException(username);

            // validate nickname
            String nickname = userDTO.getNickname();
            if (StringUtils.isBlank(nickname))
                throw new IllegalArgumentException("nickname cannot be null!");
            if (nickname.equals(user.getNickname()))
                throw new NicknameAlreadyExistException(nickname);
        }
    }

}
