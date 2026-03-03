package factories;

import animals.*;
import decorators.QuackCounter;

/**
 * CountingDuckFactory - Abstract Factory Pattern
 * Creates ducks wrapped with QuackCounter decorator
 * Automatically counts all quacks for research purposes
 */
public class CountingDuckFactory {
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    public Quackable createRedheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }

    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }

    public Quackable createGooseAdapter(Goose goose) {
        return new QuackCounter(new GooseAdapter(goose));
    }
}
