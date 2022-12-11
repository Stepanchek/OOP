package Abstacts.ArmorAbstractions;

import Abstacts.AbstractArmor;
import Abstacts.Body;
import lombok.Getter;

@Getter
public abstract class Breastplate extends AbstractArmor {
    public Breastplate(int price, int weight) {
        super(price, weight, Body.TORSO);
    }
}
