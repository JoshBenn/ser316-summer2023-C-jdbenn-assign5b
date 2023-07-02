package org.rpgmain.floor;

import org.rpgmain.CharacterBuilder;
import org.rpgmain.character.Character;


/**
 * Parent class for floor objects.
 */
public class Floor {
    private final int floorType;
    private final int floorNumber;
    private boolean cleared;
    private final Character enemy;

    /**
     * General constructor.
     * @param floorType (1) Normal, (2), Medium, (3) Boss
     * @param floorNumber the level of floor in the tower
     */
    public Floor(int floorType, int floorNumber) {
        //Set the floorType
        this.floorType = floorType;
        this.floorNumber = floorNumber;
        this.cleared = false;

        //Create a randomly generated enemy from the available choices
        CharacterBuilder characterBuilder = new CharacterBuilder();
        enemy = characterBuilder.generateCharacter();
        enemy.setEnemyHealth(floorNumber * floorType);
        enemy.setEnemyAccuracy(floorNumber);
    }

    /**
     * Applies damage inflicted to the floor mob.
     * @param damage int damage value
     */
    public void doDamage(int damage) {
        this.enemy.setHealth(-1 * damage);
        if (this.enemy.getHealth() <= 0)
            this.cleared = true;
    }

    /**
     * Provides the status of the floor.
     * @return boolean value of whether the floor is cleared
     */
    public boolean getClearedStatus() {
        return this.cleared;
    }

    /**
     * Returns the enemy on the current floor.
     * @return Character enemy
     */
    public Character getCharacter() {
        return enemy;
    }

    /**
     * Gets the value of experience earned when the floor is cleared.
     * @return int experience
     */
    public int getExperienceGain() {
        return this.floorNumber * 10 * this.floorType;
    }

    /**
     * Gets the value of gold earned when the floor is cleared.
     * @return int gold
     */
    public int getGoldGain() {
        return this.floorNumber * 100 * this.floorType;
    }

}
