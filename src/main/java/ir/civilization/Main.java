package ir.civilization;

import ir.civilization.initializer.ClassInitializer;
import ir.civilization.menu.UserMenu;
import org.apache.commons.cli.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        ClassInitializer.INSTANCE.initializeAllClasses();
        UserMenu.INSTANCE.run("user create --username abbasda --nickname absda  --password a123");
    }
}