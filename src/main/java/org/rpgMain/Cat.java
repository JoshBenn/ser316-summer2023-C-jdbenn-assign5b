package org.rpgMain;

/**
 * Cat character class.
 * Magic based damage.
 */
public class Cat extends Character {

    public Cat() {
        super(0.5, 0.5, 5, "Magic", "1");
    }

    /**
     * getImage returns an image of the character class for player.
     * @return ascii image
     */
    @Override
    public String getImage() {
        return  "    /\\/\\\n" +
                "   ( o.o) \n" +
                "  \\(  >) ";
    }

    /**
     * getEnemyImage returns an image of class if it is an enemy.
     * @return ascii image
     */
    @Override
    public String getEnemyImage() {
        return  "                        /\\/\\\n" +
                "                       (o.o ) \n" +
                "                        (<  )/ ";
    }
}