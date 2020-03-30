package sample;

public class Decorator implements Pizza {

    protected Pizza pizza;

    public Decorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice();
    }

    @Override
    public String toString() {
        return "Decorator{" +
                "pizza=" + pizza +
                '}';
    }
}

class Peperonni extends Decorator{
    public Peperonni(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 4;
    }

    @Override
    public String toString() {
        return "Peperonni{" +
                "pizza=" + pizza +
                '}';
    }
}
class Mozzarella extends Decorator{
    public Mozzarella(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 3;
    }

    @Override
    public String toString() {
        return "Mozzarella{" +
                "pizza=" + pizza +
                '}';
    }
}
class CheeseFilledCrust extends Decorator{
    public CheeseFilledCrust(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 10;
    }

    @Override
    public String toString() {
        return "CheeeseFilledCrust{" +
                "pizza=" + pizza +
                '}';
    }
}


