package ir.civilization;

import ir.civilization.holder.AuthenticatedUserHolder;
import ir.civilization.initializer.ClassInitializer;
import ir.civilization.menu.UserMenu;
import org.apache.commons.cli.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        ClassInitializer.INSTANCE.initializeAllClasses();
        UserMenu.INSTANCE.run("user login --username abbas --password a123");
        AuthenticatedUserHolder.INSTANCE.getAll().forEach(System.out::println);
        UserMenu.INSTANCE.run("user logout --username abbas");
        AuthenticatedUserHolder.INSTANCE.getAll().forEach(System.out::println);
    }
}