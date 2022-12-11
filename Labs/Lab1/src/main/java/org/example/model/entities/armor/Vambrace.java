package org.example.model.entities.armor;


import org.example.model.entities.Ammunition;

public class Vambrace extends Ammunition {
    public Vambrace(String name, double weight, double price) {
        super(name, weight, price);
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}
