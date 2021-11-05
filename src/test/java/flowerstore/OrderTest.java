package flowerstore;

import delivery.DHLDeliveryStrategy;
import delivery.PostDeliveryStrategy;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.CreditCardPaymentStrategy;
import payment.PayPalPaymentStrategy;
import user.Reciever;
import user.Status;
import user.User;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Order order;
    Reciever reciever;

    @BeforeEach
    void setUp() {
        order = new Order();
        order.addItem(new Flower(FlowerType.TULIP, 20));
        order.addItem(new Flower(FlowerType.CHAMOMILE, 13));
        order.setPaymentStrategy(new PayPalPaymentStrategy());
        order.setDeliveryStrategy(new DHLDeliveryStrategy());
        reciever = new Reciever();
        order.addUser(reciever);
    }

    @Test
    void setPaymentStrategy() {
        order.setPaymentStrategy(new CreditCardPaymentStrategy());
        assertInstanceOf(CreditCardPaymentStrategy.class, order.getPaymentStrategy());
    }

    @Test
    void setDeliveryStrategy() {
        order.setDeliveryStrategy(new PostDeliveryStrategy());
        assertInstanceOf(PostDeliveryStrategy.class, order.getDeliveryStrategy());
    }

    @Test
    void calculateTotalPrice() {
        order.addItem(new Flower(FlowerType.TULIP, 20));
        order.addItem(new Flower(FlowerType.ROSE, 12));
        assertEquals(65, order.calculateTotalPrice());
    }

    @Test
    void removeItem() {
        LinkedList<Item> orderItems = order.getItems();
        LinkedList<Item> linkedList = (LinkedList<Item>) orderItems.clone();
        linkedList.remove(linkedList.getLast());
        order.removeItem(orderItems.getLast());
        assertEquals(linkedList.size(), orderItems.size());
    }

    @Test
    void addItem() {
        LinkedList<Item> orderItems = order.getItems();
        LinkedList<Item> linkedList = (LinkedList<Item>) orderItems.clone();
        Flower flower = new Flower(FlowerType.ROSE, 12);
        linkedList.add(flower);
        order.addItem(flower);
        assertEquals(linkedList.size(), orderItems.size());
    }

    @Test
    void addUser() {
        Reciever reciever = new Reciever();
        LinkedList<User> userLinkedList = (LinkedList<User>) order.getUsers().clone();
        userLinkedList.add(reciever);
        order.addUser(reciever);
        assertEquals(userLinkedList.size(), order.getUsers().size());
    }

    @Test
    void removeUser() {
        order.removeUser(reciever);
        assertEquals(0, order.getUsers().size());
    }

    @Test
    void notifyUser() {
        order.notifyUser(reciever);
        assertEquals(Status.NOTIFIED, reciever.getStatus());
    }


    @Test
    void notifyUsers() {
        order.addUser(new Reciever());
        order.notifyUsers();
        for (User user:
             order.getUsers()) {
            assertEquals(Status.NOTIFIED, user.getStatus());
        }
    }
}