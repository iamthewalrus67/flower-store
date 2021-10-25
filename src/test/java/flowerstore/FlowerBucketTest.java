package flowerstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlowerBucketTest {
    FlowerBucket flowerBucket;

    @BeforeEach
    void setUp() {
        Flower flower1 = new Flower(FlowerType.TULIP);
        flower1.setPrice(10);

        FlowerPack flowerPack1 = new FlowerPack();
        flowerPack1.setFlower(flower1);
        flowerPack1.setAmount(20);

        flowerBucket = new FlowerBucket();
        flowerBucket.addFlowerPack(flowerPack1);
    }

    @Test
    void addFlowerPack() {
        List<FlowerPack> flowerPackList = new ArrayList<>(flowerBucket.getFlowerPacks());

        FlowerPack flowerPack2 = new FlowerPack();
        Flower flower2 = new Flower(FlowerType.ROSE);
        flower2.setPrice(12);
        flowerPack2.setFlower(flower2);
        flowerPack2.setAmount(12);

        flowerBucket.addFlowerPack(flowerPack2);
        flowerPackList.add(flowerPack2);

        assertEquals(flowerPackList, flowerBucket.getFlowerPacks());

    }

    @Test
    void getPrice() {
        assertEquals(200, flowerBucket.getPrice());
    }
}