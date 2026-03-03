package animals;

import observer.QuackObserver;
import java.util.ArrayList;
import java.util.List;

/**
 * DuckCall - A toy duck that quacks like a duck but isn't a real duck
 */
public class DuckCall implements Quackable {
    private List<QuackObserver> observers = new ArrayList<>();

    @Override
    public void quack() {
        System.out.println("Squeek! - From Duck Call (Toy)");
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
        return "Duck Call (Toy)";
    }
}
