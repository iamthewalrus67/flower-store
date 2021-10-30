package delivery;

import flowerstore.Item;

import java.util.LinkedList;

public class DHLDeliveryStrategy implements  DeliveryStrategy {

    @Override
    public void deliver(LinkedList<Item> items) {
        System.out.println("The items will be delivered by DHL");
    }
}
