package com.smarthome.command;

/**
 * 命令模式：调用者，触发命令执行。
 */
public class CommandInvoker {
    public void submit(Command command) {
        command.execute();
    }
}
