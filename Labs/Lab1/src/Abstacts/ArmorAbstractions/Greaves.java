package Abstacts.ArmorAbstractions;

import Abstacts.AbstractArmor;
import Abstacts.Body;
import lombok.Getter;

@Getter
public abstract class Greaves extends AbstractArmor {
    public Greaves(int price, int weight) {
        super(price, weight, Body.LEGS);
    }
}
