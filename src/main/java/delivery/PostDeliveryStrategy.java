package delivery;

import flowerstore.Item;

import java.util.LinkedList;

public class PostDeliveryStrategy implements DeliveryStrategy{
    @Override
    public void deliver(LinkedList<Item> items) {
        System.out.println("The items will be delivered by post");
    }
}
