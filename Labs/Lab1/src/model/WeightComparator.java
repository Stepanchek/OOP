package model;

import model.entities.Ammunition;

import java.util.Comparator;

public class WeightComparator implements Comparator<Ammunition> {
     @Override
    public int compare(Ammunition o1, Ammunition o2){
        if (o1.getWeight() == o2.getWeight()){
            return 0;
        }
        else if (o1.getWeight() > o2.getWeight()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
