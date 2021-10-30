package flowerstore;

import delivery.DeliveryStrategy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import payment.PaymentStrategy;

import java.util.LinkedList;


@Getter @Setter
public class Order {
    private LinkedList<Item> items;
    private PaymentStrategy paymentStrategy;
    private DeliveryStrategy deliveryStrategy;

    public Order() {
        items = new LinkedList<>();
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;

        for (int i = 0; i < items.size(); i++) {
            totalPrice += items.get(i).getPrice();
        }

        return totalPrice;
    }

    public void processOrder() {
        paymentStrategy.pay(calculateTotalPrice());
        deliveryStrategy.deliver(items);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
