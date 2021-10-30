package payment;

public class PayPalPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(double price) {
        System.out.printf("%.2f: PayPal%n", price);
    }
}
