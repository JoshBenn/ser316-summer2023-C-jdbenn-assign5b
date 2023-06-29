package org.example;

import java.util.Random;

public class Floor {
    private final int floorType, floorNumber;
    private boolean cleared;
    private final Character enemy;

    public Floor(int floorType, int floorNumber) {
        //Set the floorType
        this.floorType = floorType;
        this.floorNumber = floorNumber;
        this.cleared = false;

        //Create a randomly generated enemy from the available choices
        Random random = new Random();
        int enemyGenerator = random.nextInt(3) +1;
        CharacterBuilder tempEnemy = new CharacterBuilder(enemyGenerator);
        enemy = tempEnemy.getCharacter();
        enemy.setEnemyHealth(floorNumber * floorType);
        enemy.setEnemyAccuracy(floorNumber);
    }

    public void doDamage(int damage) {
        this.enemy.setHealth(-1*damage);
        if(this.enemy.getHealth() <= 0)
            this.cleared = true;
    }

    public boolean getClearedStatus() {return this.cleared;}

    public Character getCharacter() {return enemy;}

    public int getExperienceGain() {return this.floorNumber*10*this.floorType;}

    public int getGoldGain() {return this.floorNumber*100*this.floorType;}

    public int clearFloor() {
        System.out.println("You have slain the evil creature!");
        Random random = new Random();
        return random.nextInt(2);
    }
}
