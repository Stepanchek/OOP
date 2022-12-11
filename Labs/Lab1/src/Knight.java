import Abstacts.AbstractArmor;
import Abstacts.AbstractWeapon;
import lombok.*;

import java.util.*;

@Getter
@Setter

public class Knight {
    private int money;
    private int ableToLift;
    private List<AbstractArmor> armorList;
    private List<AbstractWeapon> weaponList;

    public Knight()
    {
        armorList = new ArrayList<>();
        weaponList = new ArrayList<>();
    }

    public Knight(int money, int ableToLift, List<AbstractArmor> armorList, List<AbstractWeapon> weaponList){
        this.money = money;
        this.ableToLift = ableToLift;
        this.armorList = armorList;
        this.weaponList = weaponList;
    }

    public void addArmor(AbstractArmor armor){
        armorList.add(armor);
    }

    public void addWeapon(AbstractWeapon weapon){
        weaponList.add(weapon);
    }



    public void printArmor(){
        System.out.println("~~~~~~~~~~~~~~~Armors~~~~~~~~~~~~~~~");
        for (int i = 0; i < armorList.size();i++){
            System.out.printf("%d%n%s", i, armorList.get(i));
            System.out.println("__________________________________");
        }
    }

    public class Manager {

    }
}
