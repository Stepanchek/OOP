package Abstacts.ArmorAbstractions;

import Abstacts.AbstractArmor;
import Abstacts.Body;
import lombok.Getter;

@Getter
public abstract class Helmet extends AbstractArmor {
    public Helmet(int price, int weight) {
        super(price, weight,Body.HEAD);
    }
}
