package animals;

import observer.QuackObserver;
import java.util.ArrayList;
import java.util.List;

/**
 * GooseAdapter - Adapter Pattern
 * Adapts a Goose to the Quackable interface
 * Allows Geese to be treated as Ducks
 */
public class GooseAdapter implements Quackable {
    private Goose goose;
    private List<QuackObserver> observers = new ArrayList<>();

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk(); // Adapt honk() to quack()
        notifyObservers();
    }

    @Override
    public void registerObserver(QuackObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (QuackObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "Goose (Adapted to Quackable)";
    }
}
