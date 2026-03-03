package observer;

/**
 * QuackObserver Interface - Observer Pattern
 * Observers will be notified when a duck quacks
 */
public interface QuackObserver {
    void update(Object duck);
}
