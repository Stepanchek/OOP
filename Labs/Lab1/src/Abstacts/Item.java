package Abstacts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {
    protected int weight;
    protected int price;
    public Item(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Description: %s%n"+
                             "Price: %s%n" +
                             "Weight: %s%n",
                              price,
                              weight);
    }
}
