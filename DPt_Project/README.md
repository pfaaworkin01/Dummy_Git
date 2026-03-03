# Duck Simulator - Design Patterns Project

A comprehensive demo of multiple design patterns implemented in Java through a duck simulator application.

## Project Overview

This project implements a duck simulator that demonstrates the following design patterns from your course:

1. **Factory Pattern** - Create different types of ducks
2. **Adapter Pattern** - Adapt a Goose to work as a Quackable Duck
3. **Decorator Pattern** - Count quacks by wrapping ducks with a QuackCounter
4. **Abstract Factory Pattern** - CountingDuckFactory creates pre-decorated ducks
5. **Composite Pattern** - Flock represents a collection of ducks that can be treated as a single unit
6. **Observer Pattern** - Track individual duck quacking events in real-time
7. **Iterator Pattern** - Iterate through ducks in a flock

## Project Structure

```
DPt_Project/
├── src/
│   ├── Main.java                          # Main driver program with 5 test cases
│   ├── animals/
│   │   ├── Quackable.java                # Target interface for all duck types
│   │   ├── MallardDuck.java              # Concrete duck implementation
│   │   ├── RedheadDuck.java              # Concrete duck implementation
│   │   ├── DuckCall.java                 # Toy duck implementation
│   │   ├── RubberDuck.java               # Rubber duck implementation
│   │   ├── Goose.java                    # Non-quackable animal (for adapter)
│   │   └── GooseAdapter.java             # Adapter: adapts Goose to Quackable
│   ├── factories/
│   │   ├── DuckFactory.java              # Factory: creates regular ducks
│   │   └── CountingDuckFactory.java      # Abstract Factory: creates decorated ducks
│   ├── decorators/
│   │   └── QuackCounter.java             # Decorator: counts quacks and wraps Quackables
│   ├── composite/
│   │   └── Flock.java                    # Composite: manages collections of ducks
│   └── observer/
│       ├── QuackObserver.java            # Observer interface
│       └── QuackTracker.java             # Concrete observer: tracks quacks
└── README.md                              # This file
```

## Key Patterns Explained

### 1. Quackable Interface (Base Design)
All ducks implement the `Quackable` interface which defines:
- `quack()` - Make a quacking sound
- `registerObserver()` - Register observers to track quacks
- `notifyObservers()` - Notify all registered observers

### 2. Factory Pattern
- **DuckFactory**: Creates plain ducks (MallardDuck, RedheadDuck, DuckCall, RubberDuck)
- **CountingDuckFactory**: Creates ducks pre-wrapped with QuackCounter decorator

### 3. Adapter Pattern
- **GooseAdapter**: Wraps a `Goose` object to implement the `Quackable` interface
- Allows geese to be used anywhere ducks are expected
- `goose.honk()` is adapted to `quacker.quack()`

### 4. Decorator Pattern
- **QuackCounter**: Wraps any `Quackable` to track the number of quacks
- Adds functionality without modifying the original duck classes
- Maintains a static counter of total quacks
- Can be stacked with other decorators

### 5. Abstract Factory Pattern
- **CountingDuckFactory**: Provides an alternative factory that creates pre-decorated ducks
- All ducks are automatically wrapped with QuackCounter
- Useful for research purposes where all ducks need to be counted

### 6. Composite Pattern
- **Flock**: Implements `Quackable` and contains a list of `Quackable` objects
- Can contain both individual ducks and other flocks (nested composition)
- Calling `flock.quack()` makes all ducks in the flock quack
- Treat individual ducks and collections uniformly

### 7. Observer Pattern
- **QuackObserver**: Interface for objects interested in quack events
- **QuackTracker**: Concrete observer that prints notification when a duck quacks
- Ducks maintain a list of observers and notify them when quacking
- Allows real-time tracking of individual duck quacking

### 8. Iterator Pattern
- **Flock** implements `Iterable<Quackable>`
- Can iterate through all ducks in a flock using enhanced for loop or explicit iterator
- Provides `iterator()` method to get an Iterator

## Compilation and Execution

### Compile the project:
```bash
cd /Users/princefahimal-araf/Desktop/DPt_Project
javac -d bin src/**/*.java src/Main.java
```

### Run the application:
```bash
cd /Users/princefahimal-araf/Desktop/DPt_Project
java -cp bin Main
```

Or simply:
```bash
java -cp . src/Main.java
```

## Test Cases

The `Main.java` file includes 5 comprehensive test cases:

### Test 1: Factory Pattern + Observer Pattern
- Creates ducks using DuckFactory
- Registers QuackTracker observer
- Shows how observers are notified when ducks quack

### Test 2: Adapter Pattern
- Creates a Goose object
- Adapts it using GooseAdapter to work with Quackable interface
- Shows that adapted geese can be used like regular ducks

### Test 3: Decorator Pattern (Quack Counter)
- Creates ducks wrapped with QuackCounter decorator
- Makes multiple quacks and tracks total count
- Demonstrates decorator's ability to add functionality

### Test 4: Composite Pattern with Iterator
- Creates a Flock containing multiple duck types
- Uses Iterator to iterate through all ducks in the flock
- Shows how flocks can be treated as single units

### Test 5: Complete Integration
- Uses CountingDuckFactory for automatic quack counting
- Creates nested flocks (flock within flock)
- Uses observer to track all quacks across the entire flock structure
- Demonstrates all patterns working together

## Expected Output Example

```
╔════════════════════════════════════════════════════════╗
║         DUCK SIMULATOR - Design Patterns Demo          ║
╚════════════════════════════════════════════════════════╝

┌─ TEST 1: FACTORY PATTERN + OBSERVER PATTERN ─────────┐
Creating ducks using DuckFactory and tracking quacks...

Mallard Duck quacks:
Quack quack! - From Mallard Duck
   [TRACKER] Quack tracked from: Mallard Duck

...and so on
```

## Design Principles Demonstrated

This project demonstrates several SOLID principles:

- **Open/Closed Principle**: Can add new duck types without modifying existing code
- **Liskov Substitution Principle**: All Quackable implementations can be used interchangeably
- **Dependency Inversion Principle**: Code depends on abstractions (Quackable interface)
- **Single Responsibility Principle**: Each class has a single, well-defined responsibility
- **Interface Segregation Principle**: Quackable interface is focused and minimal

## Extensions and Improvements

You can extend this project with:

1. Additional duck types (WoodDuck, PintailDuck)
2. More decorators (VolumeDecorator for adjusting quack volume)
3. Duck persistence (save/load state using Memento pattern)
4. Command pattern to undo/redo quacks
5. Strategy pattern for different movement behaviors
6. GUI using Swing or JavaFX to visualize ducks

## Notes

- All classes use proper encapsulation and access modifiers
- Comments explain each pattern and its purpose
- The code follows Java naming conventions
- Each pattern is isolated and can be understood independently
- All 5 test cases demonstrate practical pattern usage
