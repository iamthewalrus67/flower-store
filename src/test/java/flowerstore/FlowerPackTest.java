package flowerstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerPackTest {
    FlowerPack flowerPack;

    @BeforeEach
    void setUp() {
        Flower flower = new Flower(FlowerType.ROSE);
        flower.setPrice(13);
        flowerPack = new FlowerPack();
        flowerPack.setFlower(flower);
        flowerPack.setAmount(2);
    }

    @Test
    void getPrice() {
        assertEquals(26, flowerPack.getPrice());
    }

}