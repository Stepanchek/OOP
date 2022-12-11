package model.entities.armor;


import model.entities.Ammunition;

public class Greaves extends Ammunition {
    public Greaves(String name, double weight, double price) {
        super(name, weight, price);
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}
