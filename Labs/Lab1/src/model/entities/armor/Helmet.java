package model.entities.armor;

import model.entities.Ammunition;

public class Helmet extends Ammunition {
    public Helmet(String name, double weight, double price) {
        super(name, weight, price);
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}
