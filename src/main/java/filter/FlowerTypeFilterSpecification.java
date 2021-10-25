package filter;

import flowerstore.Flower;
import flowerstore.FlowerType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class FlowerTypeFilterSpecification extends FlowerFilterSpecification {
    private FlowerType flowerType;


    public FlowerTypeFilterSpecification(FlowerType flowerType) {
        setFlowerType(flowerType);
    }

    @Override
    protected List<Flower> applyFilter(List<Flower> flowers) {
        List<Flower> foundFlowers = new ArrayList<>();

        for (Flower flower: flowers) {
            if (flower.getFlowerType() == getFlowerType()) {
                foundFlowers.add(flower);
            }
        }

        return foundFlowers;
    }
}
