package payment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PaymentStrategyTest {
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    PayPalPaymentStrategy payPalPaymentStrategy;
    CreditCardPaymentStrategy creditCardPaymentStrategy;

    @BeforeEach
    void setUp() {
        payPalPaymentStrategy = new PayPalPaymentStrategy();
        creditCardPaymentStrategy = new CreditCardPaymentStrategy();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void payPayPal() {
        payPalPaymentStrategy.pay(10);
        assertEquals("10.00: PayPal", outputStreamCaptor.toString().trim());
    }

    @Test
    void payCreditCard() {
        creditCardPaymentStrategy.pay(10);
        assertEquals("10.00: Credit Card", outputStreamCaptor.toString().trim());
    }
}