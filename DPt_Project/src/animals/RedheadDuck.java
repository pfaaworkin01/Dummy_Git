package animals;

import observer.QuackObserver;
import java.util.ArrayList;
import java.util.List;

/**
 * RedheadDuck - Another concrete duck implementation
 */
public class RedheadDuck implements Quackable {
    private List<QuackObserver> observers = new ArrayList<>();

    @Override
    public void quack() {
        System.out.println("Quack quack! - From Redhead Duck");
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
        return "Redhead Duck";
    }
}
