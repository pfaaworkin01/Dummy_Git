package animals;

/**
 * Goose - A class that is not Quackable but has honk() method
 * This will be adapted to work with the Quackable interface using the Adapter pattern
 */
public class Goose {
    public void honk() {
        System.out.println("Honk honk! - From Goose");
    }

    @Override
    public String toString() {
        return "Goose";
    }
}
