# Smart Home Control System 设计模式说明

本文档用于说明本系统中关键设计模式的应用方式，内容包含模式名称、使用位置、设计意图、对应类名、代码说明与系统作用，适用于课程作业文档提交。

---

## 1. 工厂方法模式（Factory Method）
### 使用位置
设备创建模块（`factory` 包），用于按设备类型创建具体设备实例。

### 设计意图
将“对象创建”与“对象使用”解耦，使系统在新增设备类型时无需修改调用方逻辑。

### 对应类名
- `DeviceFactory`（抽象工厂接口）
- `LightFactory`、`AirConditionerFactory`、`DoorLockFactory`（具体工厂）
- `Device`、`LightDevice`、`AirConditionerDevice`（产品层次）

### 简单代码说明
```java
public interface DeviceFactory {
    Device createDevice(String deviceId);
}

public class LightFactory implements DeviceFactory {
    @Override
    public Device createDevice(String deviceId) {
        return new LightDevice(deviceId);
    }
}
```
调用方仅依赖 `DeviceFactory` 接口，不直接依赖具体设备构造细节。

### 在系统中的作用
- 降低新增设备类型的改动范围；
- 保持设备初始化流程一致性；
- 提升设备管理模块的可维护性与可扩展性。

---

## 2. 策略模式（Strategy）
### 使用位置
场景执行与自动化规则模块（`strategy` 包），用于封装不同场景下的控制算法。

### 设计意图
将多种可替换算法（如不同场景控制流程）独立封装，避免在同一业务类中出现大量条件分支。

### 对应类名
- `SceneStrategy`（策略接口）
- `ArriveHomeStrategy`、`LeaveHomeStrategy`、`NightModeStrategy`（具体策略）
- `SceneExecutor`（上下文）

### 简单代码说明
```java
public interface SceneStrategy {
    void execute(SceneContext context);
}

public class NightModeStrategy implements SceneStrategy {
    @Override
    public void execute(SceneContext context) {
        context.getLightService().setBrightness("corridor", 20);
    }
}
```
`SceneExecutor` 可在运行时切换不同策略，满足业务动态扩展。

### 在系统中的作用
- 支持场景流程按需切换；
- 降低复杂条件判断带来的耦合；
- 强化场景逻辑的可测试性与可复用性。

---

## 3. 观察者模式（Observer）
### 使用位置
设备状态变化与事件通知模块（`observer` 包），用于处理传感器事件和设备状态广播。

### 设计意图
建立“事件发布者—订阅者”机制，使状态变化可被多个模块同步感知，而不形成紧耦合调用链。

### 对应类名
- `EventPublisher`（主题/被观察者）
- `EventListener`（观察者接口）
- `SecurityAlertListener`、`EnergyStatisticsListener`（具体观察者）

### 简单代码说明
```java
public interface EventListener {
    void onEvent(DeviceEvent event);
}

public class EventPublisher {
    private final List<EventListener> listeners = new ArrayList<>();

    public void publish(DeviceEvent event) {
        for (EventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}
```
当事件发生时，发布者通知所有订阅者，订阅者各自处理业务。

### 在系统中的作用
- 实现事件驱动的模块解耦；
- 支持告警、日志、统计等横切功能并行扩展；
- 提升系统实时响应能力。

---

## 4. 命令模式（Command）
### 使用位置
设备控制指令模块（`service`/`domain`），用于封装开关、调温、上锁等操作请求。

### 设计意图
将请求封装为对象，从而支持请求参数化、日志记录、命令排队与撤销扩展。

### 对应类名
- `Command`（命令接口）
- `TurnOnLightCommand`、`SetTemperatureCommand`、`LockDoorCommand`（具体命令）
- `CommandInvoker`（调用者）
- `DeviceReceiver`（接收者）

### 简单代码说明
```java
public interface Command {
    void execute();
}

public class TurnOnLightCommand implements Command {
    private final LightDevice light;

    public TurnOnLightCommand(LightDevice light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
```
调用者不需要了解具体执行细节，只需触发命令对象执行。

### 在系统中的作用
- 统一封装设备控制动作；
- 便于新增审计日志、指令队列等功能；
- 为后续实现“撤销/重做”提供结构基础。

---

## 5. 单例模式（Singleton）
### 使用位置
系统配置与连接管理模块（如配置中心、规则引擎入口）。

### 设计意图
确保某些全局资源在系统生命周期中仅存在一个实例，避免资源重复创建与状态不一致。

### 对应类名
- `SystemConfigManager`
- `RuleEngineRegistry`

### 简单代码说明
```java
public class SystemConfigManager {
    private static final SystemConfigManager INSTANCE = new SystemConfigManager();

    private SystemConfigManager() {}

    public static SystemConfigManager getInstance() {
        return INSTANCE;
    }
}
```
通过私有构造器与静态实例控制对象唯一性。

### 在系统中的作用
- 统一管理全局配置；
- 减少重复实例导致的内存与状态开销；
- 保证关键资源访问的一致性。

---

## 总结
以上设计模式共同支撑了系统“高内聚、低耦合、易扩展”的架构目标：
- 工厂方法保障设备扩展能力；
- 策略模式与命令模式提升业务流程组织能力；
- 观察者模式支持事件驱动协作；
- 单例模式确保全局资源一致管理。

在课程作业层面，这些模式覆盖了对象创建、行为封装、模块通信与系统治理等核心设计议题，能够较好体现面向对象设计原则在实际项目中的应用价值。
