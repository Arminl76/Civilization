package ir.civilization.dto;

import org.apache.commons.cli.CommandLine;

public interface CmdLoader {
    void loadFrom(CommandLine commandLine);
}
