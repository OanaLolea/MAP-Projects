package sample;

import sample.Pizza;

public class ProsciuttoEFunghi implements Pizza {
    @Override
    public double getPrice() {
        return 31.20;
    }

    @Override
    public String toString() {
        return "ProsciuttoEFunghi{}";
    }
}
