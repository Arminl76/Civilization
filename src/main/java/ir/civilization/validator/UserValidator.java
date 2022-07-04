package ir.civilization.validator;

import ir.civilization.dao.UserDao;
import ir.civilization.dto.ChangePasswordDTO;
import ir.civilization.dto.ProfileDTO;
import ir.civilization.dto.UserDTO;
import ir.civilization.exception.CurrentPasswordIncorrectException;
import ir.civilization.exception.NicknameAlreadyExistException;
import ir.civilization.exception.SamePasswordException;
import ir.civilization.exception.UsernameAlreadyExistException;
import ir.civilization.holder.UserHolder;
import ir.civilization.model.user.User;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

public final class UserValidator {

    private static final UserDao USER_DAO = UserDao.INSTANCE;

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

    public static void validateNickname(ProfileDTO profileDTO) {
        String nickname = profileDTO.getNickname();
        if (StringUtils.isBlank(nickname))
            throw new IllegalArgumentException("nickname cannot be null!");
        if (USER_DAO.findByNickname(nickname).isPresent())
            throw new NicknameAlreadyExistException(nickname);
    }

    public static void validateChangePassword(User user, ChangePasswordDTO changePasswordDTO) {
        if (changePasswordDTO == null)
            return;

        if (!user.getPassword().equals(changePasswordDTO.getOldPassword()))
            throw new CurrentPasswordIncorrectException();

        if (changePasswordDTO.getOldPassword().equals(changePasswordDTO.getNewPassword()))
            throw new SamePasswordException();
    }

}
