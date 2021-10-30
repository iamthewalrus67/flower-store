package flowerstore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {
    private Flower flower;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        flower = new Flower(FlowerType.CHAMOMILE);
        flower.setPrice(10);
        flower.setSepalLength(5);
        flower.setColor(new int[] {127, 0, 0});
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        assertEquals(10, flower.getPrice());
    }

    @Test
    void setColor() {
        flower.setColor(new int[] {0, 0, 0});
        assertArrayEquals(new int[] {0, 0, 0}, flower.getColor());
    }

    @Test
    void getSepalLength() {
        assertEquals(5, flower.getSepalLength());
    }

    @Test
    void getColor() {
        assertArrayEquals(new int []{127, 0, 0}, flower.getColor());
    }

    @Test
    void getFlowerType() {
        assertEquals(FlowerType.CHAMOMILE, flower.getFlowerType());
    }

    @Test
    void setPrice() {
        flower.setPrice(20);
        assertEquals(20, flower.getPrice());
    }

    @Test
    void setSepalLength() {
        flower.setSepalLength(10);
        assertEquals(10, flower.getSepalLength());
    }

    @Test
    void setFlowerType() {
        flower.setFlowerType(FlowerType.TULIP);
        assertEquals(FlowerType.TULIP, flower.getFlowerType());
    }

    @Test
    void testToString() {
        assertEquals("Flower(price=10.0, sepalLength=5.0, color=[127, 0, 0], flowerType=CHAMOMILE)", flower.toString());
    }
}