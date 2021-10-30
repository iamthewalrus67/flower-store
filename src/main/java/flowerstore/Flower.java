package flowerstore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@Getter @Setter @ToString
public class Flower extends Item{
    private int price;
    private double sepalLength;
    private int[] color;
    private FlowerType flowerType;

    public Flower() {}

    public Flower(FlowerType flowerType) {
        this.flowerType = flowerType;
    }

    public Flower(FlowerType flowerType, int price) {
        this.flowerType = flowerType;
        this.price = price;
    }

    public Flower(FlowerType flowerType, int price, double sepalLength, int[] color) {
        this.flowerType = flowerType;
        this.price = price;
        this.sepalLength = sepalLength;
        setColor(color);
    }


    public void setColor(int[] color) {
        this.color = Arrays.copyOf(color, color.length);
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getDescription() {
        return String.format("This is a %s", getFlowerType());
    }
}
