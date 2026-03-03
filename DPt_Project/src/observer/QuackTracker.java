package observer;

/**
 * QuackTracker - Concrete Observer Implementation
 * Tracks individual duck quacking events in real-time
 */
public class QuackTracker implements QuackObserver {
    @Override
    public void update(Object duck) {
        System.out.println("   [TRACKER] Quack tracked from: " + duck.toString());
    }
}
