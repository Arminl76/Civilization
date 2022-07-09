package ir.civilization;

import ir.civilization.dao.user.UserDao;
import ir.civilization.initializer.ClassInitializer;
import ir.civilization.menu.map.MapMenu;
import ir.civilization.menu.profile.ProfileMenu;
import ir.civilization.menu.user.UserMenu;
import ir.civilization.security.AuthenticatedUserHolder;
import org.apache.commons.cli.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        ClassInitializer.INSTANCE.initializeAllClasses();
        UserMenu.INSTANCE.run("user create --username mmad --password a123 --nickname m");
        System.out.println(UserDao.INSTANCE.findByUsername(AuthenticatedUserHolder.INSTANCE.getPrinciple()));
        UserMenu.INSTANCE.run("user login --username mmad --password a123");
        System.out.println(UserDao.INSTANCE.findByUsername(AuthenticatedUserHolder.INSTANCE.getPrinciple()));
        ProfileMenu.INSTANCE.run("profile change --nickname mmad");
        System.out.println(UserDao.INSTANCE.findByUsername(AuthenticatedUserHolder.INSTANCE.getPrinciple()));
        ProfileMenu.INSTANCE.run("profile change --password --current a123 --new a12345");
        System.out.println(UserDao.INSTANCE.findByUsername(AuthenticatedUserHolder.INSTANCE.getPrinciple()));
        MapMenu.INSTANCE.run("map show");
        UserMenu.INSTANCE.run("user logout");
        System.out.println(AuthenticatedUserHolder.INSTANCE.getPrinciple());
        MapMenu.INSTANCE.run("map show");
    }

}