# 🏰 Kingdom Rush: Advanced Tower Defense Engine

<div align="center">

<img src="https://img.shields.io/badge/Java-11%2B-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java">
<img src="https://img.shields.io/badge/JavaFX-17-blue?style=for-the-badge&logo=openjdk&logoColor=white" alt="JavaFX">
<img src="https://img.shields.io/badge/Architecture-MVC-green?style=for-the-badge" alt="Architecture">
<img src="https://img.shields.io/badge/Concurrency-Multi--Threaded-red?style=for-the-badge" alt="Concurrency">
<img src="https://img.shields.io/badge/Design%20Pattern-Strategy%20%7C%20Factory-orange?style=for-the-badge" alt="Design Pattern">

<p align="center">
    <strong>A High-Performance, Real-Time Strategy (RTS) Defense Engine</strong><br>
    An enterprise-grade game simulation featuring complex AI pathfinding, multi-threaded game-loop synchronization, polymorphic entity systems, and a decoupled MVC architecture.
</p>

</div>

---

## Domain Model & Class Hierarchy

The core system is engineered with a rigorous Object-Oriented inheritance tree, ensuring strong polymorphism and high extensibility for future unit expansions.

### Defensive Tower Hierarchy (`Tower`)
- `Tower` *(Abstract)* — Base class for all defensive structures, managing health, upgrade logic, and cost telemetry.
  - `ArcherTower` — High-frequency, single-target physical damage.
  - `WizardTower` — Magic-based damage, ignores shielding mechanics.
  - `MortarTower` — Area of Effect (AoE) logic utilizing Euclidean collision detection.
  - `BarracksTower` *(Bonus)* — Manages a sub-lifecycle of AI-controlled militia units.

### Raider AI Hierarchy (`Raider`)
- `Raider` *(Abstract)* — Base interface for enemy entities, implementing path traversal and state management.
  - `FlyingRaider` — Bypasses ground-based obstacles using coordinate vector overrides.
  - `ShieldedRaider` — Implements damage-mitigation protocols.
  - `Saboteur` — Aggressively targets defensive structures over end-point objectives.

---

## Key Architectural Pillars

### 1. High-Performance Multi-Threaded Game Loop
To ensure a consistent **60 FPS** while managing hundreds of concurrent calculations, the engine utilizes:
- **Asynchronous Execution:** Heavy tasks like Raider AI pathfinding and collision physics are offloaded from the UI Thread using custom `ExecutorServices`.
- **Thread Safety:** Synchronization of shared game states (Gold, Health, Raider Positions) is managed via `Platform.runLater()` and atomic references to prevent race conditions during rendering cycles.

### 2. Extensible Spell & Ability System
Implemented using the **Strategy Pattern**, allowing for plug-and-play global effects:
- `Spell` *(Interface)* — Defines `drop()` and `getPrice()` contracts.
- **Global Field Effects:** Includes `Freeze` (temporal state override), `Heal` (arithmetic health mutation), and `Nuke` (mass entity deletion).

### 3. Dynamic MVC Rendering Engine
- **Controller:** Orchestrates event-driven interactions, map pathing logic, and state synchronization.
- **Model:** Handles pure mathematical coordinate vectors and entity statistics.
- **View:** Reactive FXML/JavaFX interface that monitors model state changes via the **Observer Pattern**.

### 4. Robust Custom Exception Handling
Centralized error handling for game lifecycle failures:
- `InvalidPlacementException`: Triggered when entity coordinates violate grid-map constraints.
- `InsufficientFundsException`: Ensures atomic transaction security during tower construction/upgrades.
- `LevelLoadException`: Handles resource/asset corruption during scene initialization.

---

## 🏗️ Technical Project Topology
```text
src/
├── controller/        # Game Loop Engine, Input Handlers, Thread Manager
├── model/             # Entities (Tower/Raider), Pathing Algorithms, State Database
├── view/              # FXML Layouts, CSS Skins, JavaFX Render Nodes
├── exceptions/        # Domain-specific game logic error classes
├── interfaces/        # Spell contracts and Entity behaviors
└── module-info.java   # Modular project configuration
