package flowerstore;

import delivery.DeliveryStrategy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import payment.PaymentStrategy;
import user.Status;
import user.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Getter @Setter
public class Order {
    private LinkedList<Item> items;
    private List<User> users;
    private PaymentStrategy paymentStrategy;
    private DeliveryStrategy deliveryStrategy;

    public Order() {
        items = new LinkedList<>();
        users = new ArrayList<>();
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
        notifyUsers();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void notifyUser(User user) {
        user.update(Status.NOTIFIED);
    }

    public void notifyUsers() {
        for (User user:
             users) {
            user.update(Status.NOTIFIED);
        }
    }
}
