# Design Patterns Implementation Guide

## Quick Reference

### Pattern 1: Factory Pattern
**File**: [src/factories/DuckFactory.java](src/factories/DuckFactory.java)

**Purpose**: Encapsulates the creation of different duck objects

**Example Usage**:
```java
DuckFactory factory = new DuckFactory();
Quackable mallard = factory.createMallardDuck();
Quackable redhead = factory.createRedheadDuck();
```

---

### Pattern 2: Adapter Pattern (Structural)
**File**: [src/animals/GooseAdapter.java](src/animals/GooseAdapter.java)

**Purpose**: Adapts a Goose (which has `honk()`) to work as a Quackable (which needs `quack()`)

**Key Classes**:
- `Goose.java` (Adaptee) - Original class with incompatible interface
- `GooseAdapter.java` (Adapter) - Implements Quackable and wraps Goose

**Example Usage**:
```java
Goose goose = new Goose();
Quackable adaptedGoose = new GooseAdapter(goose);
adaptedGoose.quack();  // Internally calls goose.honk()
```

---

### Pattern 3: Decorator Pattern (Structural)
**File**: [src/decorators/QuackCounter.java](src/decorators/QuackCounter.java)

**Purpose**: Adds the ability to count quacks to any Quackable without modifying the original class

**How It Works**:
- Wraps a Quackable object
- Increments counter on each quack
- Delegates other method calls to wrapped object

**Example Usage**:
```java
Quackable duck = new MallardDuck();
Quackable countedDuck = new QuackCounter(duck);
countedDuck.quack();  // Counts and then quacks
countedDuck.quack();  // Counts and then quacks
System.out.println("Total: " + QuackCounter.getQuacks());  // Output: 2
```

---

### Pattern 4: Abstract Factory Pattern
**File**: [src/factories/CountingDuckFactory.java](src/factories/CountingDuckFactory.java)

**Purpose**: Creates families of related objects (ducks pre-wrapped with QuackCounter)

**Difference from Factory Pattern**:
- Factory Pattern: Creates individual objects
- Abstract Factory: Creates families of objects with consistent characteristics

**Example Usage**:
```java
CountingDuckFactory factory = new CountingDuckFactory();
Quackable duck = factory.createMallardDuck();  // Automatically decorated
```

---

### Pattern 5: Composite Pattern (Structural)
**File**: [src/composite/Flock.java](src/composite/Flock.java)

**Purpose**: Compose objects into tree structures to represent part-whole hierarchies

**Characteristics**:
- Implements the same interface as its components (Quackable)
- Can contain both individual ducks and other flocks
- Allows treating individual objects and compositions uniformly

**Example Usage**:
```java
Flock mainFlock = new Flock();
Flock mallardFlock = new Flock();

// Add ducks to sub-flock
mallardFlock.add(new MallardDuck());
mallardFlock.add(new MallardDuck());

// Add sub-flock to main flock
mainFlock.add(mallardFlock);
mainFlock.add(new RedheadDuck());

// Call quack() on flock - all ducks quack!
mainFlock.quack();
```

---

### Pattern 6: Observer Pattern (Behavioral)
**Files**: 
- [src/observer/QuackObserver.java](src/observer/QuackObserver.java)
- [src/observer/QuackTracker.java](src/observer/QuackTracker.java)

**Purpose**: Define a one-to-many relationship where when one object changes state, all dependents are notified

**Components**:
- **Observer Interface**: QuackObserver
- **Concrete Observer**: QuackTracker
- **Observable**: Any Quackable (maintains list of observers)

**Example Usage**:
```java
Quackable duck = new MallardDuck();
QuackTracker tracker = new QuackTracker();

duck.registerObserver(tracker);  // Subscribe
duck.quack();                     // Triggers update() on tracker
```

---

### Pattern 7: Iterator Pattern (Behavioral)
**Implemented in**: [src/composite/Flock.java](src/composite/Flock.java)

**Purpose**: Access elements of a collection sequentially without exposing its underlying representation

**Key Interface**: `Iterable<Quackable>`

**Example Usage**:
```java
Flock flock = new Flock();
flock.add(new MallardDuck());
flock.add(new RedheadDuck());

// Using enhanced for loop (Iterator internally)
for (Quackable duck : flock) {
    System.out.println(duck);
}

// Using explicit iterator
Iterator<Quackable> iterator = flock.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

---

## Pattern Relationships

```
┌──────────────────────────────────────────────────────────┐
│                  QUACKABLE INTERFACE                     │
│  (The contract all ducks must follow)                    │
├──────────────────────────────────────────────────────────┤
│  - quack()                                               │
│  - registerObserver(observer)                            │
│  - notifyObservers()                                     │
└──────────────────────────────────────────────────────────┘
          ▲                    ▲              ▲
          │                    │              │
    ┌─────┴────────┐    ┌──────┴──────┐   ┌──┴──────────────┐
    │  Concrete    │    │  Decorator  │   │  Composite      │
    │  Ducks       │    │  (Quack     │   │  (Flock)        │
    │              │    │   Counter)  │   │                 │
    └──────────────┘    └─────────────┘   └─────────────────┘
          ▲                    ▲              ▲
          │ created by         │ wraps       │ contains
          │                    │             │
    ┌─────┴─────┐         Decorator         │
    │ Factory   │         Pattern           │
    └───────────┘                        Iterator
                                         Pattern
```

---

## Test Case Breakdown

### Test 1: Factory + Observer
- **What**: Creates ducks using factory and tracks their quacks
- **Patterns Used**: Factory, Observer
- **Learning**: How to create objects and observe their behavior

### Test 2: Adapter
- **What**: Demonstrates adapting a Goose to work as a Quackable
- **Patterns Used**: Adapter
- **Learning**: How to make incompatible interfaces work together

### Test 3: Decorator
- **What**: Counts quacks using decorator pattern
- **Patterns Used**: Decorator
- **Learning**: How to add functionality without modifying original classes

### Test 4: Composite + Iterator
- **What**: Creates a flock and iterates through ducks
- **Patterns Used**: Composite, Iterator, Observer
- **Learning**: How to handle collections uniformly with iteration

### Test 5: Complete Integration
- **What**: Uses all patterns together
- **Patterns Used**: All 7 patterns
- **Learning**: Real-world scenario with multiple patterns working together

---

## Common Interview Questions

**Q: What's the difference between Adapter and Decorator?**
- Adapter: Changes an interface to make incompatible objects work
- Decorator: Adds functionality to an object without changing its interface

**Q: Why use Factory instead of `new` keyword?**
- Encapsulates creation logic
- Makes it easy to change creation logic in one place
- Enables polymorphic creation

**Q: When should I use Composite over simple collections?**
- When you need recursive composition (tree structures)
- When you want uniform treatment of individuals and groups
- When you want transparent handling of complex/primitive objects

**Q: How does Observer differ from Callback?**
- Observer: One-to-many relationship, loose coupling
- Callback: Direct reference to another object's method

**Q: Why is Iterator Pattern important?**
- Separates collection implementation from traversal
- Allows different iteration strategies
- Enables concurrent iteration safely
