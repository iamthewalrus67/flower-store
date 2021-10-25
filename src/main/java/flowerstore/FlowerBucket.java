package flowerstore;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter @Getter
public class FlowerBucket {
    List<FlowerPack> flowerPacks = new ArrayList<>();
    List<Flower> flowers = new ArrayList<>();

    public void addFlowerPack(FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
        flowers.add(flowerPack.getFlower());
    }

    public double getPrice() {
        double price = 0;

        for (int i = 0; i < flowerPacks.size(); i++) {
            price += flowerPacks.get(i).getPrice();
        }

        return price;
    }
}
