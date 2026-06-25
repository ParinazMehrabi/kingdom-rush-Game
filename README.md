# 🏰 Kingdom Rush: Advanced Tower Defense Engine

<div align="center">

![Java](https://img.shields.io/badge/Java-11%2B-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-17-blue?style=for-the-badge&logo=openjdk&logoColor=white)
![Architecture](https://img.shields.io/badge/Architecture-MVC-green?style=for-the-badge)
![Threading](https://img.shields.io/badge/Threading-Multi--Threaded-red?style=for-the-badge)

</div>

## 📖 Overview
A sophisticated, high-performance Tower Defense game engine developed as a final project for Advanced Programming. This project focuses on **Clean Code principles**, **architectural integrity**, and **real-time concurrent processing** using JavaFX.

## 🚀 Key Engineering Highlights
*   **Architectural Pattern:** Strictly decoupled **Model-View-Controller (MVC)** to ensure separation of concerns between game logic, data persistence, and UI rendering.
*   **Concurrency & Performance:** Utilized `AnimationTimer` and specialized thread pools to decouple high-overhead calculations (collision detection, pathfinding) from the UI thread, ensuring a stable **60 FPS**.
*   **Object-Oriented Design:** Leveraged deep polymorphism to implement a flexible entity system. Abstract base classes for `Tower` and `Raider` allow for easy expansion of game units.
*   **Modular Architecture:** Structured using modern `module-info.java` to enforce encapsulation and manage dependencies efficiently.

## 🛠 Technical Specifications
### Game Entities
*   **Polymorphic Raiders:** Diverse enemy types with unique AI behaviors (e.g., Flying, Shielded, Saboteur).
*   **Defensive Towers:** Strategic grid-based placement with upgradeable levels and distinct damage types (Physical, Magical, AoE, Summoning).
*   **Spell Interface:** An extensible interface-driven system for game-changing global effects (Heal, Freeze, Economy Boost, Global Cleansing).

### Engine Components
- **Controller:** Manages user input, lifecycle events, and state synchronization.
- **Model:** Handles complex coordinate vectors, map pathing, and entity statistics.
- **View:** FXML-based modular UI with dynamic resource rendering.

## 🏗️ Project Structure
```text
src/
├── controller/        # Event-driven input handlers
├── model/             # Core logic, state management, and entities
├── view/              # JavaFX UI lifecycle and scene management
└── exceptions/        # Custom runtime error handling
resources/
├── view/              # FXML layouts
└── images/            # Assets and graphical sprites
