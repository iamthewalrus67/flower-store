package filter;

import flowerstore.Flower;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter @Setter
public class PriceFilterSpecification extends FlowerFilterSpecification {
    private int price;

    public PriceFilterSpecification(int price) {
        setPrice(price);
    }

    @Override
    protected List<Flower> applyFilter(List<Flower> flowers) {
        List<Flower> foundFlowers = new ArrayList<>();

        for (Flower flower: flowers) {
            if (flower.getPrice() == getPrice()) {
                foundFlowers.add(flower);
            }
        }

        return foundFlowers;
    }
}
