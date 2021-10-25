package flowerstore;

import filter.ColorFilterSpecification;
import filter.FlowerTypeFilterSpecification;
import filter.PriceFilterSpecification;
import filter.SepalLengthFilterSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    Store store;
    Flower flower1, flower2, flower3, flower4;

    @BeforeEach
    void setUp() {
        store = new Store();

        flower1 = new Flower(FlowerType.ROSE, 12, 50, new int[] {0, 0, 127});
        flower2 = new Flower(FlowerType.TULIP, 20, 40, new int[] {127, 0, 0});
        flower3 = new Flower(FlowerType.CHAMOMILE, 20, 50, new int[] {0, 127, 0});
        flower4 = new Flower(FlowerType.ROSE, 30, 60, new int[] {0, 0, 127});


        store.addFlower(flower1);
        store.addFlower(flower2);
        store.addFlower(flower3);
        store.addFlower(flower4);
    }

    @Test
    void search() {
        List<Flower> flowers = new ArrayList<>();
        flowers.add(flower1);
        flowers.add(flower4);
        List<Flower> foundFlowers = store.search(new ColorFilterSpecification(new int[] {0, 0, 127}));
        assertArrayEquals(flowers.toArray(), foundFlowers.toArray());

        flowers.clear();
        flowers.add(flower1);
        flowers.add(flower4);
        foundFlowers = store.search(new FlowerTypeFilterSpecification(FlowerType.ROSE));
        assertArrayEquals(flowers.toArray(), foundFlowers.toArray());

        flowers.clear();
        flowers.add(flower2);
        flowers.add(flower3);
        foundFlowers = store.search(new PriceFilterSpecification(20));
        assertArrayEquals(flowers.toArray(), foundFlowers.toArray());

        flowers.clear();
        flowers.add(flower1);
        flowers.add(flower3);
        foundFlowers = store.search(new SepalLengthFilterSpecification(50));
        assertArrayEquals(flowers.toArray(), foundFlowers.toArray());
    }
}