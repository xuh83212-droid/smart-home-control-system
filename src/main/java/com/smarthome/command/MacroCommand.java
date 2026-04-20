package com.smarthome.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令模式：宏命令，可批量执行多个命令。
 */
public class MacroCommand implements Command {
    private final List<Command> commands = new ArrayList<>();

    public void add(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
