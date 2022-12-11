package model.entities.armor;

import model.entities.Ammunition;

public class Breastplate extends Ammunition {
    public Breastplate(String name, double weight, double price) {
        super(name, weight, price);
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}
