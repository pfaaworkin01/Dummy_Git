package decorators;

import animals.Quackable;
import observer.QuackObserver;

/**
 * QuackCounter - Decorator Pattern
 * Wraps a Quackable object to count the number of quacks
 * Adds the ability to track quacks without modifying the original duck classes
 */
public class QuackCounter implements Quackable {
    private Quackable duck;
    private static int numberOfQuacks = 0;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    @Override
    public void registerObserver(QuackObserver observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }

    public static int getQuacks() {
        return numberOfQuacks;
    }

    public static void resetQuacks() {
        numberOfQuacks = 0;
    }

    @Override
    public String toString() {
        return duck.toString() + " (Counted)";
    }
}
