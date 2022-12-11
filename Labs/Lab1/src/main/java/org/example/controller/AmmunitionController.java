package org.example.controller;


import org.example.model.Knight;
import org.example.model.entities.armor.*;
import org.example.model.entities.weapons.*;
import org.example.view.AmmunitionView;

import java.util.Scanner;

public class AmmunitionController {
    private Knight knight = new Knight();
    private AmmunitionView view = new AmmunitionView();

    public void run(){
        Scanner input = new Scanner(System.in);
        int command;
        while (true){
            view.printAllCommands();
            command = input.nextInt();
            doCommand(command);
            if (command == 6){
                return;
            }
        }
    }

    private void doCommand(int command){
        Scanner input = new Scanner(System.in);
        switch (command){
            case 1:
                view.printAmmunitionList(knight.getAmmunition());
                break;
            case 2:
                view.printAddAmmunitionCommands();
                handleAddCommand(input.nextInt());
                break;
            case 3:
                view.printCost(knight.calculateCost());
                break;
            case 4:
                view.printSorted(knight.sortAmmunitionByWeight());
                break;
            case 5:
                view.printAskFor("left bound");
                double leftBound = input.nextDouble();
                view.printAskFor("right bound");
                view.printByPriceRange(
                        knight.getAmmunitionByPriceRange(
                                leftBound,
                                input.nextDouble()
                        )
                );
                break;
            default:
                return;
        }
    }
    private void handleAddCommand(int command){
        Scanner input = new Scanner(System.in);
        view.printAskFor("name");
        String name = input.nextLine();
        view.printAskFor("weight");
        double weight = input.nextDouble();
        view.printAskFor("price");
        double price = input.nextDouble();

        switch (command){
            case 1:
                knight.equipAmmunition(new Helmet(name, weight, price),true);
                break;
            case 2:
                knight.equipAmmunition(new Breastplate(name, weight, price),true);
                break;
            case 3:
                knight.equipAmmunition(new Vambrace(name, weight, price),true);
                break;
            case 4:
                knight.equipAmmunition(new Pants(name, weight, price),true);
                break;
            case 5:
                knight.equipAmmunition(new Greaves(name, weight, price),true);
                break;
            case 6:
                knight.equipAmmunition(new Sword(name, weight, price),true);
                break;
            case 7:
                knight.equipAmmunition(new Spear(name, weight, price),true);
                break;
            case 8:
                knight.equipAmmunition(new Bow(name, weight, price),true);
                break;
            case 9:
                knight.equipAmmunition(new Arrow(name, weight, price),true);
                break;
            case 10:
                knight.equipAmmunition(new Shield(name, weight, price),true);
                break;
            default:
                return;
        }
    }
}