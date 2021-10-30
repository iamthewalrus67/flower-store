package delivery;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryStrategyTest {
    DHLDeliveryStrategy dhlDeliveryStrategy;
    PostDeliveryStrategy postDeliveryStrategy;
    // For asserting print
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();;

    @BeforeEach
    void setUp() {
        dhlDeliveryStrategy = new DHLDeliveryStrategy();
        postDeliveryStrategy = new PostDeliveryStrategy();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);;
    }

    @Test
    void deliverDHL() {
        dhlDeliveryStrategy.deliver(null);
        assertEquals("The items will be delivered by DHL", outputStreamCaptor.toString().trim());
    }

    @Test
    void deliverPost() {
        postDeliveryStrategy.deliver(null);
        assertEquals("The items will be delivered by post", outputStreamCaptor.toString().trim());
    }
}