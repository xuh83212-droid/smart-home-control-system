package com.smarthome.history;

import com.smarthome.command.Command;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OperationHistory {
    private final Stack<Command> undoStack = new Stack<>();
    private final List<String> auditLog = new ArrayList<>();

    public void execute(Command command) {
        command.execute();
        undoStack.push(command);
        auditLog.add(command.description());
    }

    public void undoLast() {
        if (!undoStack.isEmpty()) {
            Command last = undoStack.pop();
            last.undo();
            auditLog.add("Undo " + last.description());
        }
    }

    public List<String> getAuditLog() {
        return List.copyOf(auditLog);
    }
}
