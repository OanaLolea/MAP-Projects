package sample;

public interface PaymentStrategy {

    public boolean pay(double amount);

    public void collectPaymentDetails();
}
