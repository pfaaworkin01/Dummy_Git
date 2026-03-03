package factories;

import animals.*;
import decorators.QuackCounter;

/**
 * DuckFactory - Factory Pattern
 * Creates different types of ducks
 */
public class DuckFactory {
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }

    public Quackable createDuckCall() {
        return new DuckCall();
    }

    public Quackable createRubberDuck() {
        return new RubberDuck();
    }

    public Quackable createGooseAdapter(Goose goose) {
        return new GooseAdapter(goose);
    }
}
