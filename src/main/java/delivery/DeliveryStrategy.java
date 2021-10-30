package delivery;

import flowerstore.Item;

import java.util.LinkedList;

public interface DeliveryStrategy {
    void deliver(LinkedList<Item> items);
}
