package model.entities.weapons;

import model.entities.Ammunition;

public class Sword extends Ammunition {
    public Sword(String name, double weight, double price) {
        super(name, weight, price);
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}