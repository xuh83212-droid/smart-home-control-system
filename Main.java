import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface SmartDevice {
    void turnOn();

    void turnOff();

    String getStatus();

    String getName();
}

class Light implements SmartDevice {
    private final String name;
    private boolean on;

    public Light(String name) {
        this.name = name;
        this.on = false;
    }

    @Override
    public void turnOn() {
        on = true;
        System.out.println("[Light] " + name + " 已打开");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("[Light] " + name + " 已关闭");
    }

    @Override
    public String getStatus() {
        return on ? "ON" : "OFF";
    }

    @Override
    public String getName() {
        return name;
    }
}

class AirConditioner implements SmartDevice {
    private final String name;
    private boolean on;

    public AirConditioner(String name) {
        this.name = name;
        this.on = false;
    }

    @Override
    public void turnOn() {
        on = true;
        System.out.println("[AirConditioner] " + name + " 已打开");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("[AirConditioner] " + name + " 已关闭");
    }

    @Override
    public String getStatus() {
        return on ? "ON" : "OFF";
    }

    @Override
    public String getName() {
        return name;
    }
}

class Humidifier implements SmartDevice {
    private final String name;
    private boolean on;

    public Humidifier(String name) {
        this.name = name;
        this.on = false;
    }

    @Override
    public void turnOn() {
        on = true;
        System.out.println("[Humidifier] " + name + " 已打开");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("[Humidifier] " + name + " 已关闭");
    }

    @Override
    public String getStatus() {
        return on ? "ON" : "OFF";
    }

    @Override
    public String getName() {
        return name;
    }
}

abstract class CompositeNode implements SmartDevice {
    protected final String name;
    protected final List<SmartDevice> children = new ArrayList<>();

    protected CompositeNode(String name) {
        this.name = name;
    }

    public void add(SmartDevice device) {
        children.add(device);
    }

    public List<SmartDevice> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public void turnOn() {
        System.out.println("[Composite] 打开 " + name + " 下所有子设备/组件");
        for (SmartDevice child : children) {
            child.turnOn();
        }
    }

    @Override
    public void turnOff() {
        System.out.println("[Composite] 关闭 " + name + " 下所有子设备/组件");
        for (SmartDevice child : children) {
            child.turnOff();
        }
    }

    @Override
    public String getStatus() {
        if (children.isEmpty()) {
            return "EMPTY";
        }
        boolean allOn = true;
        boolean allOff = true;
        for (SmartDevice child : children) {
            String status = child.getStatus();
            allOn &= "ON".equals(status);
            allOff &= "OFF".equals(status);
        }
        if (allOn) {
            return "ON";
        }
        if (allOff) {
            return "OFF";
        }
        return "PARTIAL";
    }

    @Override
    public String getName() {
        return name;
    }
}

class Room extends CompositeNode {
    public Room(String name) {
        super(name);
    }
}

class Floor extends CompositeNode {
    public Floor(String name) {
        super(name);
    }
}

interface Command {
    void execute();

    void undo();

    String getName();
}

class TurnOnCommand implements Command {
    private final SmartDevice target;

    public TurnOnCommand(SmartDevice target) {
        this.target = target;
    }

    @Override
    public void execute() {
        target.turnOn();
    }

    @Override
    public void undo() {
        target.turnOff();
    }

    @Override
    public String getName() {
        return "TurnOn(" + target.getName() + ")";
    }
}

class TurnOffCommand implements Command {
    private final SmartDevice target;

    public TurnOffCommand(SmartDevice target) {
        this.target = target;
    }

    @Override
    public void execute() {
        target.turnOff();
    }

    @Override
    public void undo() {
        target.turnOn();
    }

    @Override
    public String getName() {
        return "TurnOff(" + target.getName() + ")";
    }
}

class MacroCommand implements Command {
    private final String name;
    private final List<Command> commands;

    public MacroCommand(String name, List<Command> commands) {
        this.name = name;
        this.commands = new ArrayList<>(commands);
    }

    @Override
    public void execute() {
        System.out.println("[Macro] 执行命令组: " + name);
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        System.out.println("[Macro] 撤销命令组: " + name);
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }

    @Override
    public String getName() {
        return "Macro(" + name + ")";
    }
}

class OperationHistory {
    private final List<String> records = new ArrayList<>();
    private final List<Command> executedCommands = new ArrayList<>();

    public void recordExecution(Command command) {
        records.add("执行: " + command.getName());
        executedCommands.add(command);
    }

    public void undoLast() {
        if (executedCommands.isEmpty()) {
            System.out.println("[History] 没有可撤销的操作");
            return;
        }
        Command last = executedCommands.remove(executedCommands.size() - 1);
        last.undo();
        records.add("撤销: " + last.getName());
    }

    public void printHistory() {
        System.out.println("\n===== 操作历史 =====");
        if (records.isEmpty()) {
            System.out.println("(空)");
            return;
        }
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i + 1) + ". " + records.get(i));
        }
    }
}

class CommandInvoker {
    private final OperationHistory history;

    public CommandInvoker(OperationHistory history) {
        this.history = history;
    }

    public void executeCommand(Command command) {
        command.execute();
        history.recordExecution(command);
    }

    public void undoLastCommand() {
        history.undoLast();
    }
}

public class Main {
    public static void main(String[] args) {
        Room livingRoom = new Room("客厅");
        Room bedRoom = new Room("卧室");

        Light smartLight = new Light("智能灯");
        AirConditioner airConditioner = new AirConditioner("空调");
        Humidifier humidifier = new Humidifier("加湿器");

        livingRoom.add(smartLight);
        livingRoom.add(humidifier);
        bedRoom.add(airConditioner);

        Floor firstFloor = new Floor("一楼");
        firstFloor.add(livingRoom);
        firstFloor.add(bedRoom);

        OperationHistory history = new OperationHistory();
        CommandInvoker invoker = new CommandInvoker(history);

        System.out.println("\n=== 初始状态 ===");
        printStatus(smartLight, airConditioner, humidifier, livingRoom, bedRoom, firstFloor);

        System.out.println("\n=== Step 1: 先打开部分设备，模拟已有运行状态 ===");
        smartLight.turnOn();
        humidifier.turnOn();
        printStatus(smartLight, airConditioner, humidifier, livingRoom, bedRoom, firstFloor);

        System.out.println("\n=== Step 2: 一键关闭客厅（Composite + Command） ===");
        Command closeLivingRoom = new TurnOffCommand(livingRoom);
        invoker.executeCommand(closeLivingRoom);
        printStatus(smartLight, airConditioner, humidifier, livingRoom, bedRoom, firstFloor);

        System.out.println("\n=== Step 3: 执行打开空调命令（Command） ===");
        Command openAc = new TurnOnCommand(airConditioner);
        invoker.executeCommand(openAc);
        printStatus(smartLight, airConditioner, humidifier, livingRoom, bedRoom, firstFloor);

        System.out.println("\n=== Step 4: 撤销上一步操作（History + Undo） ===");
        invoker.undoLastCommand();
        printStatus(smartLight, airConditioner, humidifier, livingRoom, bedRoom, firstFloor);

        System.out.println("\n=== Step 5: 演示 MacroCommand（打开客厅设备+空调） ===");
        Command macro = new MacroCommand(
                "全屋开机",
                List.of(new TurnOnCommand(livingRoom), new TurnOnCommand(airConditioner))
        );
        invoker.executeCommand(macro);
        printStatus(smartLight, airConditioner, humidifier, livingRoom, bedRoom, firstFloor);

        history.printHistory();
    }

    private static void printStatus(SmartDevice... devices) {
        for (SmartDevice device : devices) {
            System.out.printf("- %-10s : %s%n", device.getName(), device.getStatus());
        }
    }
}
