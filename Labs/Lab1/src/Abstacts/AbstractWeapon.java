package Abstacts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractWeapon extends Item {
    protected int price;
    protected int weight;

    public AbstractWeapon(int price, int weight) {
        super(price, weight);
    }
}
