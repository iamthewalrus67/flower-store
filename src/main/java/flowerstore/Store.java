package flowerstore;

import filter.FlowerFilterSpecification;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Flower> flowers = new ArrayList<>();

    void addFlower(Flower flower) {
        flowers.add(flower);
    }

    List<Flower> search(FlowerFilterSpecification filterSpecification) {
        return filterSpecification.filter(flowers);
    }
}
