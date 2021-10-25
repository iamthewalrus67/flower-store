package filter;

import flowerstore.Flower;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter @Setter
public class ColorFilterSpecification extends FlowerFilterSpecification {
    private int[] color;

    public ColorFilterSpecification(int[] color) {
        setColor(color);
    }

    public void setColor(int[] color) {
        this.color = Arrays.copyOf(color, color.length);
    }

    @Override
    protected List<Flower> applyFilter(List<Flower> flowers) {
        List<Flower> foundFlowers = new ArrayList<>();

        for (Flower flower: flowers) {
            if (Arrays.equals(flower.getColor(), getColor())) {
                foundFlowers.add(flower);
            }
        }

        return foundFlowers;
    }
}
