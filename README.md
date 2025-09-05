# The Hero's Choice

A text-based adventure game written in Java where you play as a hero on a rescue mission to save a princess trapped in a mysterious cave system.

## 📖 Story

You are an adventurer traveling around a peaceful village when you suddenly hear a woman screaming from a cave. Determined to help, you decide to rescue the lady by venturing into the dangerous cave system. After following the screams into the cave, an epic adventure begins where your choices will determine what happens next.

Your quest is clear: navigate through the treacherous cave depths, rescue the trapped princess, and escape safely.

## 🎮 Gameplay Features

### Core Mechanics
- **Grid-based Movement**: Navigate through a 4x4 cave system using cardinal directions
- **Item Collection**: Find and collect useful items like torches, maps, and swords
- **NPC Interactions**: Meet allies who offer guidance and face enemies who oppose your mission
- **Inventory Management**: Keep track of collected items and use them strategically
- **Save/Load System**: Save your progress and continue your adventure later

### Game Elements
- **Player**: The hero character with customizable name and location tracking
- **Items**: 
  - **Torch**: Lights your way but may attract unwanted attention
  - **Map**: Shows your current location in the cave system
  - **Sword**: Prepares you for battle against enemies
- **NPCs**:
  - **Miner**: A friendly ally who provides guidance and support
  - **Princess**: The person you're trying to rescue
  - **Kidnapper**: The dangerous enemy who opposes your mission

## 🎯 Objective

Navigate through the cave system, collect useful items, interact with NPCs, and successfully rescue the princess while making strategic choices that affect the outcome of your adventure.

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line or terminal access
- Make (optional, for using Makefile commands)

### Installation & Running

1. **Clone or download** this repository to your local machine
   
2. **Navigate** to the project directory:
   ```bash
   cd The-Hero-s-Choice
   ```

3. **Quick Start (using Makefile)**:
   ```bash
   make run
   ```
   
   **Or compile and run manually**:
   ```bash
   # Compile
   make compile
   # OR manually: javac -d build src/*.java
   
   # Run
   java -cp build HeroesChoiceMain
   ```

### Available Make Commands
- `make run` - Compile and run the game
- `make compile` - Compile all Java files  
- `make clean` - Remove compiled class files
- `make clean-all` - Remove entire build directory
- `make help` - Show available commands

## 🎮 How to Play

### Starting the Game
1. When you start the game, you'll see the introductory story
2. Choose between:
   - **1. NEW GAME**: Start a fresh adventure
   - **2. PREVIOUS GAME**: Continue from a saved game (if available)

### Game Commands
Once in the game, you can use the following commands:

#### Movement
- `north` - Move north (increase Y coordinate)
- `south` - Move south (decrease Y coordinate)
- `east` - Move east (increase X coordinate)
- `west` - Move west (decrease X coordinate)

#### Actions
- `inventory` - Check your current inventory
- `torch` - Use the torch (if you have it)
- `map` - Use the map to see your location (if you have it)
- `sword` - Wield the sword for battle (if you have it)
- `help` - Display available commands and game objective
- `quit` - Quit the game (with option to save)

### Item Collection
- When you encounter an item, you'll be asked if you want to pick it up
- Type `yes` to add the item to your inventory
- Items appear at specific locations in the 4x4 grid

### NPC Encounters
- NPCs appear at designated locations throughout the cave
- Each encounter provides story elements and may affect your adventure
- Pay attention to their descriptions and advice

### Saving Your Game
- When you type `quit`, you'll be prompted to save your progress
- Type `y` to save or `n` to quit without saving
- Saved games are stored in `src/data/save.txt`

## 🏗️ Project Structure

```
The-Hero-s-Choice/
├── src/                         # Source code directory
│   ├── game/                    # Main game logic package
│   │   ├── HeroesChoiceMain.java    # Main entry point
│   │   ├── GameLogic.java           # Core game logic and mechanics
│   │   └── Story.java               # Story and narrative content
│   ├── entities/                # Game entities package  
│   │   ├── Player.java              # Player class with movement and actions
│   │   ├── NPC.java                 # Base NPC class
│   │   ├── Ally.java                # Friendly NPC subclass
│   │   └── Enemy.java               # Hostile NPC subclass
│   ├── items/                   # Items and inventory package
│   │   ├── Item.java                # Item system
│   │   └── Inventory.java           # Inventory management
│   ├── utils/                   # Utility classes package
│   │   ├── Location.java            # Grid coordinate system
│   │   ├── SaveGame.java            # Game saving functionality
│   │   └── LoadGame.java            # Game loading functionality
│   └── data/                    # Game data
│       └── save.txt                 # Game save file (generated)
├── build/                       # Compiled class files (.class)
│   ├── game/                    # Compiled game classes
│   ├── entities/                # Compiled entity classes
│   ├── items/                   # Compiled item classes
│   └── utils/                   # Compiled utility classes
├── docs/                        # Documentation (future expansion)
├── assets/                      # Game assets (future expansion)
├── .gitignore                   # Git ignore file
├── Makefile                     # Build automation
└── README.md                    # This file
```

## 🎨 Game Map

The game uses a 4x4 grid coordinate system:

```
(0,3) (1,3) (2,3) (3,3)
(0,2) (1,2) (2,2) (3,2)
(0,1) (1,1) (2,1) (3,1)
(0,0) (1,0) (2,0) (3,0)
```

- **Starting Position**: (0,0)
- **Item Locations**:
  - Torch: (2,2)
  - Map: (0,1)
  - Sword: (0,2)
- **NPC Locations**:
  - Miner (Ally): (1,1)
  - Princess: (4,4) - Your rescue target
  - Kidnapper (Enemy): (3,3)

## 🔧 Technical Details

### Key Classes and Methods

#### GameLogic
- `start()` - Begins the game loop
- `exploreCave()` - Main exploration mechanics
- `newGame()` - Starts a new game
- `loadPreviousGame()` - Loads saved game
- `pickUpItem()` - Handles item collection
- `NpcEncounter()` - Manages NPC interactions

#### Player
- `move(String direction)` - Handles player movement
- `useItem(String itemName)` - Uses items from inventory
- `pickUpItem(Item item)` - Adds items to inventory
- `checkInventory()` - Displays current inventory

#### Location
- `moveNorth()`, `moveSouth()`, `moveEast()`, `moveWest()` - Movement methods
- Boundary checking to prevent moving outside the 4x4 grid

### Save System
- Games are saved using Java serialization
- Save files are stored in `src/save.txt`
- All game state including player position, inventory, and NPC encounter status is preserved

## 🐛 Troubleshooting

### Common Issues

1. **"Something went wrong" error**: Usually indicates an input issue. Make sure to enter valid numbers (1 or 2) at the main menu.

2. **Save/Load not working**: Ensure the `src` directory exists and has write permissions.

3. **Compilation errors**: Make sure you have Java JDK installed and are in the correct directory.

4. **Game freezes**: If the game becomes unresponsive, use Ctrl+C to exit.

## 🎯 Tips for Players

1. **Explore systematically**: The cave is only 4x4, so you can explore every location
2. **Collect all items**: Each item has a specific use that can help in your adventure
3. **Talk to allies**: The miner provides valuable guidance
4. **Use the map**: It helps you navigate and track your progress
5. **Save regularly**: Use the quit and save feature to preserve your progress

## 🎮 Game Design Philosophy

This game emphasizes:
- **Choice and consequence**: Your decisions matter
- **Exploration**: Discover items and NPCs through systematic exploration
- **Resource management**: Collect and use items strategically
- **Narrative immersion**: Simple story text with timed displays for dramatic effect

## 🔧 Development

### Building the Project
```bash
# Clean previous builds
make clean-all

# Compile the project
make compile

# Run the game
make run
```

### Code Structure
The project follows object-oriented design principles:
- **Inheritance**: NPC → Ally/Enemy classes
- **Encapsulation**: Private fields with public getters/setters
- **Polymorphism**: Different NPC behaviors through method overriding
- **File I/O**: Save/load game functionality using Java serialization

### Future Enhancements
- [ ] Combat system with health points
- [ ] More complex inventory interactions
- [ ] Multiple endings based on choices
- [ ] Sound effects (stored in `assets/` directory)
- [ ] Expanded cave system with more levels
- [ ] Achievement system

## 👤 About

A text-based adventure game showcasing object-oriented programming concepts in Java, including inheritance, encapsulation, file I/O, and game state management.

## 🎉 Enjoy Your Adventure!

Prepare yourself for an adventure that will test your courage. Make your choices wisely, as they will determine the fate of both you and the princess you're trying to rescue!