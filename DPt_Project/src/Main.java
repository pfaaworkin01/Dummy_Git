import animals.*;
import factories.*;
import decorators.QuackCounter;
import composite.Flock;
import observer.QuackTracker;

import java.util.Iterator;

/**
 * Main - Duck Simulator Application
 * Demonstrates all design patterns:
 * 1. Factory Pattern - Create ducks using factories
 * 2. Adapter Pattern - Adapt Goose to Quackable
 * 3. Decorator Pattern - Count quacks using QuackCounter
 * 4. Composite Pattern - Manage flocks of ducks with Iterator
 * 5. Observer Pattern - Track individual duck quacking
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║         DUCK SIMULATOR - Design Patterns Demo          ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        // Test 1: Factory Pattern with Observer
        testFactoryAndObserver();

        // Test 2: Adapter Pattern
        testAdapterPattern();

        // Test 3: Decorator Pattern (Quack Counting)
        testDecoratorPattern();

        // Test 4: Composite Pattern with Iterator
        testCompositePattern();

        // Test 5: Complete Integration Test
        testCompleteIntegration();
    }

    /**
     * Test 1: Factory Pattern with Observer Pattern
     */
    private static void testFactoryAndObserver() {
        System.out.println("\n┌─ TEST 1: FACTORY PATTERN + OBSERVER PATTERN ─────────┐");
        System.out.println("Creating ducks using DuckFactory and tracking quacks...\n");

        DuckFactory factory = new DuckFactory();
        QuackTracker tracker = new QuackTracker();

        Quackable mallard = factory.createMallardDuck();
        Quackable redhead = factory.createRedheadDuck();
        Quackable rubberDuck = factory.createRubberDuck();

        // Register observer to track quacks
        mallard.registerObserver(tracker);
        redhead.registerObserver(tracker);
        rubberDuck.registerObserver(tracker);

        System.out.println("Mallard Duck quacks:");
        mallard.quack();

        System.out.println("Redhead Duck quacks:");
        redhead.quack();

        System.out.println("Rubber Duck quacks:");
        rubberDuck.quack();
        System.out.println("└───────────────────────────────────────────────────────┘");
    }

    /**
     * Test 2: Adapter Pattern
     */
    private static void testAdapterPattern() {
        System.out.println("\n┌─ TEST 2: ADAPTER PATTERN ─────────────────────────────┐");
        System.out.println("Adapting Goose to work with Quackable interface...\n");

        Goose goose = new Goose();
        Quackable adaptedGoose = new GooseAdapter(goose);

        QuackTracker tracker = new QuackTracker();
        adaptedGoose.registerObserver(tracker);

        System.out.println("Original Goose honks directly:");
        goose.honk();

        System.out.println("\nAdapted Goose used as a Quackable:");
        adaptedGoose.quack();

        System.out.println("└───────────────────────────────────────────────────────┘");
    }

    /**
     * Test 3: Decorator Pattern - Quack Counting
     */
    private static void testDecoratorPattern() {
        System.out.println("\n┌─ TEST 3: DECORATOR PATTERN (QUACK COUNTER) ───────────┐");
        System.out.println("Counting quacks using decorator...\n");

        QuackCounter.resetQuacks();
        
        Quackable duck1 = new QuackCounter(new MallardDuck());
        Quackable duck2 = new QuackCounter(new RedheadDuck());
        Quackable duck3 = new QuackCounter(new RubberDuck());

        System.out.println("Duck 1 quacks 3 times:");
        duck1.quack();
        duck1.quack();
        duck1.quack();

        System.out.println("Duck 2 quacks 2 times:");
        duck2.quack();
        duck2.quack();

        System.out.println("Duck 3 quacks 1 time:");
        duck3.quack();

        System.out.println("\nTotal quacks counted: " + QuackCounter.getQuacks());
        System.out.println("└───────────────────────────────────────────────────────┘");
    }

    /**
     * Test 4: Composite Pattern with Iterator
     */
    private static void testCompositePattern() {
        System.out.println("\n┌─ TEST 4: COMPOSITE PATTERN (FLOCK) WITH ITERATOR ────┐");
        System.out.println("Creating a flock and iterating through ducks...\n");

        QuackCounter.resetQuacks();
        
        DuckFactory factory = new DuckFactory();
        Flock flock = new Flock();

        // Add ducks to the flock
        flock.add(factory.createMallardDuck());
        flock.add(factory.createRedheadDuck());
        flock.add(factory.createDuckCall());
        flock.add(factory.createRubberDuck());

        // Register observer for the entire flock
        QuackTracker tracker = new QuackTracker();
        flock.registerObserver(tracker);

        System.out.println("Flock Info: " + flock);
        System.out.println("\nIterating through flock using Iterator:");
        Iterator<Quackable> iterator = flock.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            System.out.println("  " + count + ". " + iterator.next().toString());
            count++;
        }

        System.out.println("\nFlock quacking:");
        flock.quack();
        System.out.println("└───────────────────────────────────────────────────────┘");
    }

    /**
     * Test 5: Complete Integration - All Patterns Together
     */
    private static void testCompleteIntegration() {
        System.out.println("\n┌─ TEST 5: COMPLETE INTEGRATION (ALL PATTERNS) ────────┐");
        System.out.println("Using CountingDuckFactory with Flock and Observer...\n");

        QuackCounter.resetQuacks();
        
        // Using CountingDuckFactory (wraps all ducks with QuackCounter)
        CountingDuckFactory countingFactory = new CountingDuckFactory();
        
        // Create main flock
        Flock mainFlock = new Flock();
        
        // Create mallard flock (sub-flock using composite)
        Flock mallardFlock = new Flock();
        mallardFlock.add(countingFactory.createMallardDuck());
        mallardFlock.add(countingFactory.createMallardDuck());
        mainFlock.add(mallardFlock);

        // Add individual ducks
        mainFlock.add(countingFactory.createRedheadDuck());
        mainFlock.add(countingFactory.createDuckCall());
        
        // Add adapted goose
        Goose goose = new Goose();
        mainFlock.add(countingFactory.createGooseAdapter(goose));

        // Register observer to track all quacks
        QuackTracker tracker = new QuackTracker();
        mainFlock.registerObserver(tracker);

        System.out.println("Main Flock Configuration: " + mainFlock);
        System.out.println("\nExecuting synchronized flock quack:");
        mainFlock.quack();

        System.out.println("Total quacks counted by decorator: " + QuackCounter.getQuacks());
        System.out.println("└───────────────────────────────────────────────────────┘");

        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║                  SIMULATION COMPLETE                   ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
