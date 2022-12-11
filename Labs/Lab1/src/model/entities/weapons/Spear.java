package model.entities.weapons;

import model.entities.Ammunition;

public class Spear extends Ammunition {
    public Spear(String name, double weight, double price) {
        super(name, weight, price);
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}