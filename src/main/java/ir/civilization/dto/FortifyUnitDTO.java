package ir.civilization.dto;

import ir.civilization.menu.unit.UnitMenu;
import lombok.Getter;
import org.apache.commons.cli.CommandLine;

@Getter
public class FortifyUnitDTO implements CmdLoader {

    private boolean hasHealFlag;

    @Override
    public void loadFrom(CommandLine commandLine) {
        this.hasHealFlag = this.load_hasHeal(commandLine);
    }

    private boolean load_hasHeal(CommandLine commandLine) {
        return commandLine.hasOption(UnitMenu.OPTIONS_HEAL);
    }

}
