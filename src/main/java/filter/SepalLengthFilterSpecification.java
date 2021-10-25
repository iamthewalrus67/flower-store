package filter;

import flowerstore.Flower;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class SepalLengthFilterSpecification extends FlowerFilterSpecification {
    private double sepalLength;

    public SepalLengthFilterSpecification(double price) {
        setSepalLength(price);
    }

    @Override
    protected List<Flower> applyFilter(List<Flower> flowers) {
        List<Flower> foundFlowers = new ArrayList<>();

        for (Flower flower: flowers) {
            if (flower.getSepalLength() == getSepalLength()) {
                foundFlowers.add(flower);
            }
        }

        return foundFlowers;
    }
}
