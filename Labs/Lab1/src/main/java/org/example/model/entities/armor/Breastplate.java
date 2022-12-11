package org.example.model.entities.armor;


import org.example.model.entities.Ammunition;

public class Breastplate extends Ammunition {
    public Breastplate(String name, double weight, double price) {
        super(name, weight, price);
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}
