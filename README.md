# Smart Home Control System

## 1. 项目名称
**Smart Home Control System（智能家居控制系统）**

## 2. 项目背景
随着物联网设备在家庭场景中的普及，用户对“统一接入、集中控制、自动化联动”的需求日益明显。传统方案通常存在设备协议不一致、控制入口分散、扩展能力不足等问题。为解决上述痛点，本项目围绕“设备抽象层 + 场景编排 + 统一控制接口”进行设计与实现，目标是在教学实践中构建一个结构清晰、易于扩展的智能家居控制系统原型。

该项目可作为面向对象分析与设计课程、软件体系结构课程的课程作业，重点体现设计模式在实际业务中的应用方法。

## 3. 核心功能
1. **设备统一管理**：支持灯光、空调、门锁、传感器等设备的统一注册与状态维护。
2. **统一控制接口**：通过统一服务层下发控制指令，降低上层业务对具体设备实现的依赖。
3. **场景模式控制**：支持“回家模式”“离家模式”“夜间模式”等一键场景执行。
4. **自动化规则联动**：基于时间或事件（如人体传感）触发设备联动策略。
5. **系统状态监控**：提供设备在线状态与执行结果反馈，便于调试与运维。
6. **可扩展架构设计**：通过接口与设计模式降低新增设备类型和新增业务流程的实现成本。

## 4. 技术栈
> 注：以下为课程作业推荐技术栈，可根据授课要求调整。

- **后端语言**：Java 17
- **构建工具**：Maven
- **Web 框架**：Spring Boot
- **数据存储**：MySQL / H2（开发阶段）
- **缓存与消息**：Redis（可选）
- **接口规范**：RESTful API
- **测试框架**：JUnit 5
- **文档工具**：Markdown

## 5. 项目结构
```text
smart-home-control-system/
├── README.md
├── docs/
│   └── design-patterns.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/smarthome/
│   │   │       ├── controller/      # 控制层：对外提供 API
│   │   │       ├── service/         # 业务层：场景编排与控制逻辑
│   │   │       ├── domain/          # 领域模型：设备、场景、规则等
│   │   │       ├── strategy/        # 各类策略实现
│   │   │       ├── factory/         # 设备工厂
│   │   │       └── observer/        # 事件监听与通知
│   │   └── resources/
│   │       ├── application.yml
│   │       └── schema.sql
│   └── test/
│       └── java/
└── pom.xml
```

## 6. 如何运行
### 6.1 环境准备
- JDK 17 及以上
- Maven 3.8+
- MySQL 8.0+（若使用 H2 可跳过）

### 6.2 克隆项目
```bash
git clone <your-repo-url>
cd smart-home-control-system
```

### 6.3 配置文件
根据实际环境修改 `src/main/resources/application.yml`，例如数据库连接、端口号与日志级别。

### 6.4 启动项目
```bash
mvn clean spring-boot:run
```

### 6.5 运行测试
```bash
mvn test
```

## 7. 运行效果示例
### 7.1 触发“回家模式”
```http
POST /api/scenes/arrive-home/execute
```

**预期执行流程：**
1. 系统加载场景编排配置；
2. 打开客厅灯光；
3. 将空调设置为 26℃；
4. 解锁智能门锁；
5. 返回场景执行结果与各设备状态。

**示例响应：**
```json
{
  "scene": "arrive-home",
  "status": "SUCCESS",
  "actions": [
    "LightDevice:ON",
    "AirConditionerDevice:SET_26",
    "DoorLockDevice:UNLOCK"
  ],
  "timestamp": "2026-04-19T12:00:00Z"
}
```

### 7.2 自动化联动示例
当人体传感器检测到夜间活动时，系统自动触发“夜灯模式”，仅开启低亮度走廊灯，以兼顾安全性与节能需求。

---
如需查看系统中设计模式的详细说明，请参考：[`docs/design-patterns.md`](docs/design-patterns.md)。
