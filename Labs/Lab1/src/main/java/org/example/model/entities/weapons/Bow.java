package org.example.model.entities.weapons;


import org.example.model.entities.Ammunition;

public class Bow extends Ammunition {
    public Bow(String name, double weight, double price) {
        super(name, weight, price);
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}