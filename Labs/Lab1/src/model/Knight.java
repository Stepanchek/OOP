package model;

import model.entities.Ammunition;
import view.AmmunitionView;

import java.util.ArrayList;
import java.util.Collections;

public class Knight {
    private ArrayList<Ammunition> ammunition = new ArrayList<>();
    private AmmunitionView view = new AmmunitionView();

    public ArrayList<Ammunition> getAmmunition() {
        return ammunition;
    }

    public ArrayList<Ammunition> sortAmmunitionByWeight(){
        Collections.sort(ammunition, new WeightComparator());

        return ammunition;
    }

    public ArrayList<Ammunition> getAmmunitionByPriceRange(double from, double to){
        ArrayList<Ammunition> ans = new ArrayList<>();

        for (Ammunition i : ammunition){
            if (i.getPrice() <= to && i.getPrice() >= from){
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean addAmmunition(Ammunition toAdd){
        if (!checkIfPresentAmmunition(toAdd.getType())){
            ammunition.add(toAdd);
            return true;
        }

        return false;
    }

    public void replaceAmmunition(Ammunition toReplace){
        String type = toReplace.getType();

        for (int i = 0, size = ammunition.size(); i < size; ++i){
            if (ammunition.get(i).getType().equals(type)){
                ammunition.set(i, toReplace);
                return;
            }
        }
    }

    public void equipAmmunition(Ammunition toEquip, boolean ask){
        if (addAmmunition(toEquip)){
            if (ask && view.askIfSure("replace current ammunition with a new piece")){
                replaceAmmunition(toEquip);
            }else{
                replaceAmmunition(toEquip);
            }
        }
    }

    public double calculateCost(){
        double ans = 0.0;

        for (Ammunition i : ammunition){
            ans += i.getPrice();
        }

        return ans;
    }

    private boolean checkIfPresentAmmunition(String toCheck){
        for (Ammunition i : ammunition){
            if (i.getType().equals(toCheck)){
                return true;
            }
        }

        return false;
    }
}
