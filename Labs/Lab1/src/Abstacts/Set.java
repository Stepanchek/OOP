package Abstacts;

import Abstacts.ArmorAbstractions.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;

@Getter
public class Set {
    /*
    private List<Breastplate> breastplates;
    private List<Greaves> greaves;
    private List<Helmet> helmets;
    private List<Vambrace> vambraces;
    */
    private EnumMap<Body, List<AbstractArmor>> armors;

    public Set(){
        armors = new EnumMap<Body, List<AbstractArmor>>(Body.class);
    }

    public Set(EnumMap<Body, List<AbstractArmor>> armors){
        this.armors = armors;
    }

    /*
    public Set(){
       breastplates = new ArrayList<>();
       greaves = new ArrayList<>();
       helmets = new ArrayList<>();
       vambraces = new ArrayList<>();
    }
    public List<Item> sortByWeight(AbstractArmor armors, AbstractWeapon weapons){
        List<Breastplate> toSort = breastplates;
        toSort.sort(new Comparator<Breastplate>() {
            @Override
            public int compare(Breastplate o1, Breastplate o2) {
                return 0;
            }
        });
    }
    */

}
