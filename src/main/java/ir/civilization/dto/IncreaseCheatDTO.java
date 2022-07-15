package ir.civilization.dto;

import ir.civilization.menu.cheat.CheatMenu;
import lombok.Getter;
import org.apache.commons.cli.CommandLine;

@Getter
public class IncreaseCheatDTO implements CmdLoader {

    private Integer turn;
    private Integer gold;

    @Override
    public void loadFrom(CommandLine commandLine) {
        this.turn = this.load_turn(commandLine);
        this.gold = this.load_gold(commandLine);
    }

    private Integer load_turn(CommandLine commandLine) {
        if (commandLine.hasOption(CheatMenu.OPTIONS_TURN))
            return Integer.parseInt(commandLine.getOptionValue(CheatMenu.OPTIONS_TURN));

        return null;
    }

    private Integer load_gold(CommandLine commandLine) {
        if (commandLine.hasOption(CheatMenu.OPTIONS_GOLD))
            return Integer.parseInt(commandLine.getOptionValue(CheatMenu.OPTIONS_GOLD));

        return null;
    }

}
