package sample;

import javafx.beans.InvalidationListener;

import java.util.ArrayList;
import java.util.Observable;

public class Order extends Observable {

    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

    public void add(Pizza pizza){
        pizzas.add(pizza);
        setChanged();
        notifyObservers();
    }

    public double getTotal(){
        double s = 0;
        for(Pizza p:pizzas)
            s += p.getPrice();
        return s;
    }

    public void processOrder(PaymentStrategy strategy){
        strategy.collectPaymentDetails();
        strategy.pay(getTotal());
    }
}
