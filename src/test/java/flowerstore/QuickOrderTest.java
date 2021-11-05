package flowerstore;

import delivery.DHLDeliveryStrategy;
import delivery.PostDeliveryStrategy;
import org.junit.jupiter.api.Test;
import payment.CreditCardPaymentStrategy;
import payment.PayPalPaymentStrategy;

import static org.junit.jupiter.api.Assertions.*;

class QuickOrderTest {

    @Test
    void createOrder() {
        Order order = QuickOrder.createOrder(QuickOrder.CHAMOMILE_BUCKET);
        assertInstanceOf(CreditCardPaymentStrategy.class, order.getPaymentStrategy());
        assertEquals(100, order.calculateTotalPrice());
        assertInstanceOf(PostDeliveryStrategy.class, order.getDeliveryStrategy());
    }
}