package org.example;

import java.util.Random;

public class Weapon extends Armor {
    public Weapon(String[] gameState) {
        super(0.05, 0.01, gameState);
    }

    @Override
    public String getImage() {
        if(super.getWeaponType().equals("Physical"))
            return "-|====>";
        else
            return "----*";
    }
}
