package flowerstore;

import delivery.PostDeliveryStrategy;
import payment.CreditCardPaymentStrategy;
import payment.PayPalPaymentStrategy;

public enum QuickOrder {
    ROSE_BUCKET, TULIP_BUCKET, CHAMOMILE_BUCKET;

    public static Order createOrder(QuickOrder quickOrder) {
        Order order;
        FlowerBucket flowerBucket;
        FlowerPack flowerPack = new FlowerPack();
        Flower flower = null;
        FlowerType flowerType;

        if (quickOrder == ROSE_BUCKET) {
            flower = new Flower(FlowerType.ROSE, 10, 10, new int[] {127, 0, 0});
        } else if (quickOrder == TULIP_BUCKET) {
            flower = new Flower(FlowerType.TULIP, 10, 10, new int[] {0, 127, 0});
        } else if (quickOrder == CHAMOMILE_BUCKET) {
            flower = new Flower(FlowerType.CHAMOMILE, 10, 10, new int[] {0, 0, 127});
        }

        flowerPack.setFlower(flower);
        flowerPack.setAmount(10);
        flowerBucket = new FlowerBucket();
        flowerBucket.addFlowerPack(flowerPack);

        order = new Order();
        order.addItem(flowerBucket);
        order.setPaymentStrategy(new CreditCardPaymentStrategy());
        order.setDeliveryStrategy(new PostDeliveryStrategy());
        return order;
    }
}
