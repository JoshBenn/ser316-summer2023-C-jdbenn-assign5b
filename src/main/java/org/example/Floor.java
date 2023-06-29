package org.example;

import java.util.Random;

public class Floor {
    private final int floorType, floorNumber;
    private boolean cleared;
    private final CharacterBuilder enemy;

    public Floor(int floorType, int floorNumber) {
        //Set the floorType
        this.floorType = floorType;
        this.floorNumber = floorNumber;
        this.cleared = false;

        //Create a randomly generated enemy from the available choices
        Random random = new Random();
        int enemyGenerator = random.nextInt(3);
        enemy = new CharacterBuilder(enemyGenerator);
        //enemy.getCharacter().setBossHealth(floorNumber * floorType);
    }

    public void doDamage(int damage) {
        this.enemy.getCharacter().setHealth(-1*damage);
        if(this.enemy.getCharacter().getHealth() <= 0)
            this.cleared = true;
    }

    public boolean getClearedStatus() {return this.cleared;}

    public int getExperienceGain() {return this.floorNumber*10*this.floorType;}

    public int getGoldGain() {return this.floorNumber*100*this.floorType;}
}
