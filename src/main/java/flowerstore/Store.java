package flowerstore;

import java.util.ArrayList;
import java.util.List;

public class Store {
    List<FlowerBucket> flowerBucketList = new ArrayList<>();

    void addFlowerBucket(FlowerBucket flowerBucket) {
        flowerBucketList.add(flowerBucket);
    }

    void search(FlowerType flowerType) {
        for (int i = 0; i < flowerBucketList.size(); i++) {
            for (int j = 0; j < flowerBucketList.get(i).getFlowerPacks().size(); j++) {
                Flower flower = flowerBucketList.get(i).getFlowers().get(j);
                if (flowerType == flower.getFlowerType()) {
                    System.out.println(flower.toString() + " was found in bucket " + i);
                }
            }
        }
    }
}
