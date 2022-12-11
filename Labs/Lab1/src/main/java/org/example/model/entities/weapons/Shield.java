package org.example.model.entities.weapons;


import org.example.model.entities.Ammunition;

public class Shield extends Ammunition {
    public Shield(String name, double weight, double price) {
        super(name, weight, price);
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}