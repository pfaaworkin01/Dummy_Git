package composite;

import animals.Quackable;
import observer.QuackObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Flock - Composite Pattern
 * Represents a collection (flock) of ducks
 * Treats individual ducks and collections of ducks in the same way
 * Uses Iterator to iterate through the ducks
 */
public class Flock implements Quackable, Iterable<Quackable> {
    private List<Quackable> quackers = new ArrayList<>();

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    public void remove(Quackable quacker) {
        quackers.remove(quacker);
    }

    @Override
    public void quack() {
        System.out.println(">>> Flock begins quacking <<<");
        for (Quackable quacker : quackers) {
            quacker.quack();
        }
        System.out.println(">>> Flock finishes quacking <<<\n");
    }

    @Override
    public void registerObserver(QuackObserver observer) {
        for (Quackable quacker : quackers) {
            quacker.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Quackable quacker : quackers) {
            quacker.notifyObservers();
        }
    }

    @Override
    public Iterator<Quackable> iterator() {
        return quackers.iterator();
    }

    public int size() {
        return quackers.size();
    }

    @Override
    public String toString() {
        return "Flock with " + quackers.size() + " ducks";
    }
}
