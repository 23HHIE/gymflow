# Gymflow

Gymflow 是一个基于 **Spring Boot + Maven multi-module + PostgreSQL + Flyway** 的后端项目，用于模拟健身房系统的模块化/微服务演进结构。

当前阶段目标：
- 建立 **清晰的模块边界**
- 跑通 **本地开发环境**
- 为后续 **消息队列 / 服务拆分** 做结构准备

---

## Project Structure:

gymflow/
├─ gymflow-app/ # 主应用（Spring Boot 入口）
│ ├─ src/main/java
│ └─ src/main/resources
│
├─ gymflow-modules/ # 业务模块（未来可拆成微服务）
│ ├─ inventory/ # 器械 / 场馆库存
│ ├─ identity/ # 用户 / 身份（预留）
│ ├─ session/ # 训练 session（预留）
│ ├─ queue/ # 消息/异步（预留）
│ └─ notification/ # 通知（预留）
│
├─ docker/
│ └─ docker-compose.yml # 本地 PostgreSQL
│
├─ pom.xml # 父 POM（聚合模块）
├─ mvnw # Maven Wrapper
└─ README.md

## Prerequisites

本地需要：

- **Java 21**
- **Docker / Docker Compose**
- 不需要本地安装 PostgreSQL（通过 Docker 提供）

---

## Local Development – Quick Start

### 1. 启动 PostgreSQL（Docker）

在项目根目录：
## Run with Docker

```bash
docker compose -f docker/docker-compose.yml up -d
```

数据库默认：
Host: localhost
Port: 5432
DB: gymflow
User: gymflow
Password: gymflow

## 2. 启动应用
   在 项目根目录 执行：
   ```bash
   ./mvnw -pl gymflow-app -am spring-boot:run
   ```
   说明：
   -pl gymflow-app：只启动主应用
   -am：自动构建所依赖的模块（如 inventory）
   应用启动后：
   服务地址：http://localhost:8080

## Database & Migrations
数据库 schema 由 Flyway 管理
migration 文件位置：
gymflow-app/src/main/resources/db/migration
例如：
V1__init.sql
Flyway 会在应用启动时：
自动执行未应用过的 migration
校验 schema 是否与 JPA entity 匹配

## Inventory Module (Example)
已实现示例模块：inventory
示例接口：

GET /gyms/{gymId}/machines
返回健身房下的器械列表。

### Common Commands
```bash
# 停止并清空数据库（慎用）
docker compose -f docker/docker-compose.yml down -v

# 查看依赖树（调试模块问题）
./mvnw -pl gymflow-app dependency:tree

# 只构建 inventory 模块
./mvnw -pl gymflow-modules/inventory clean install
```

### Design Notes
- 当前为 modular monolith
- 每个 module：
   - 独立 pom.xml
   - 独立 domain / repository / controller
- 后续可逐步演进为：
   - 消息队列（Kafka / RabbitMQ）
   - 独立微服务
