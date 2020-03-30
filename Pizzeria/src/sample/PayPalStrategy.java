package sample;

public class PayPalStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        return false;
    }

    @Override
    public void collectPaymentDetails() {

    }
}
