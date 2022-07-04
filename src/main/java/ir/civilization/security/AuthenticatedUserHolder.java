package ir.civilization.security;

import ir.civilization.dao.UserDao;
import ir.civilization.exception.UnAuthorizedException;
import ir.civilization.exception.UserNotFountException;
import ir.civilization.model.user.User;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class AuthenticatedUserHolder {

    public static final AuthenticatedUserHolder INSTANCE = new AuthenticatedUserHolder();

    private static final ThreadLocal<String> USERNAME_TL = new ThreadLocal<>();

    private final UserDao userDao = UserDao.INSTANCE;

    private AuthenticatedUserHolder() {
    }

    public String getPrinciple() {
        return USERNAME_TL.get();
    }

    public User getAuthenticatedUser() {
        String principle = this.getPrinciple();
        if (StringUtils.isBlank(principle))
            throw new UnAuthorizedException();

        Optional<User> user = userDao.findByUsername(principle);
        if (!user.isPresent())
            throw new UserNotFountException();

        return user.get();
    }

    public void setPrinciple(User user) {
        USERNAME_TL.set(user.getUsername());
    }

    public void removePrinciple() {
        USERNAME_TL.remove();
    }

    public boolean isPresent(User user) {
        return user.getUsername().equals(USERNAME_TL.get());
    }

}
