package Abstacts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractArmor extends Item{
    protected int price;
    protected int weight;
    public Body body;

    public AbstractArmor(int price, int weight, Body body) {
        super(price, weight);
        this.body = body;
    }

}
