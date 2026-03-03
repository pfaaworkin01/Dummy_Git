package animals;

/**
 * Quackable Interface - The target interface that all ducks must implement
 */
public interface Quackable {
    void quack();
    void registerObserver(observer.QuackObserver observer);
    void notifyObservers();
}
