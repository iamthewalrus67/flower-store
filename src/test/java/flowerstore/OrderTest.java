package flowerstore;

import delivery.DHLDeliveryStrategy;
import delivery.PostDeliveryStrategy;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.CreditCardPaymentStrategy;
import payment.PayPalPaymentStrategy;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
        order.addItem(new Flower(FlowerType.TULIP, 20));
        order.addItem(new Flower(FlowerType.CHAMOMILE, 13));
        order.setPaymentStrategy(new PayPalPaymentStrategy());
        order.setDeliveryStrategy(new DHLDeliveryStrategy());
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
}