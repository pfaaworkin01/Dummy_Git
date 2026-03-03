package animals;

import observer.QuackObserver;
import java.util.ArrayList;
import java.util.List;

/**
 * RubberDuck - A rubber duck that squeaks
 */
public class RubberDuck implements Quackable {
    private List<QuackObserver> observers = new ArrayList<>();

    @Override
    public void quack() {
        System.out.println("Squeek squeek! - From Rubber Duck");
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
        return "Rubber Duck";
    }
}
