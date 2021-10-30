package payment;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double price) {
        System.out.printf("%.2f: Credit Card%n", price);
    }
}
