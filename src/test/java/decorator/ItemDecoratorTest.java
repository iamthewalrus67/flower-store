package decorator;

import flowerstore.Flower;
import flowerstore.FlowerType;
import flowerstore.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDecoratorTest {
    BasketDecorator basketDecorator;
    PaperDecorator paperDecorator;
    RibbonDecorator ribbonDecorator;

    @BeforeEach
    void setUp() {
        Item item = new Flower(FlowerType.ROSE, 12, 15, new int[]{127, 0, 0});
        basketDecorator = new BasketDecorator(item);
        paperDecorator = new PaperDecorator(item);
        ribbonDecorator = new RibbonDecorator(item);
    }

    @Test
    void getPrice() {
        assertEquals(16, basketDecorator.getPrice());
        assertEquals(25, paperDecorator.getPrice());
        assertEquals(52, ribbonDecorator.getPrice());
    }

    @Test
    void getDescription() {
        assertEquals("This is a ROSE", basketDecorator.getDescription());
    }
}