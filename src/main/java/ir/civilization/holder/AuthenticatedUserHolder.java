package ir.civilization.holder;

import ir.civilization.model.user.User;

import java.util.Collection;
import java.util.HashSet;

public class AuthenticatedUserHolder implements ObjectHolder<User> {

    public static final AuthenticatedUserHolder INSTANCE = new AuthenticatedUserHolder();

    private static final Collection<User> AUTHENTICATED_USERS = new HashSet<>();

    private AuthenticatedUserHolder() {
    }

    @Override
    public void cache(User user) {
        this.remove(user);
        AUTHENTICATED_USERS.add(user);
    }

    @Override
    public void remove(User user) {
        AUTHENTICATED_USERS.remove(user);
    }

    @Override
    public void clearCache() {
        AUTHENTICATED_USERS.clear();
    }

    @Override
    public Collection<User> getAll() {
        return AUTHENTICATED_USERS;
    }

}
