package Abstacts.ArmorAbstractions;

import Abstacts.AbstractArmor;
import Abstacts.Body;
import lombok.Getter;

@Getter
public abstract class Vambrace extends AbstractArmor {
    public Vambrace(int price, int weight) {
        super(price, weight,Body.ARMS);
    }
}
