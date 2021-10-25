package filter;

import flowerstore.Flower;

import java.util.List;

public abstract class FlowerFilterSpecification {
    public List<Flower> filter(List<Flower> flowers) {
        return applyFilter(flowers);
    }

    protected abstract List<Flower> applyFilter(List<Flower> flowers);
}
