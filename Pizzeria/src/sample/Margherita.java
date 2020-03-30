package sample;

public class Margherita implements Pizza {
    @Override
    public double getPrice() {
        return 15;
    }

    @Override
    public String toString() {
        return "Margherita{}";
    }
}
