package org.rpgMain;

import org.rpgMain.Armor.Armor;
import org.rpgMain.Character.Character;

/**
 * Output management system.
 */
public class DisplayOutput {
    /**
     * Generates the main output to keep that "game" feel.
     * @param gameState state of the current game
     * @param armorSet the set of armor as necessary
     * @param player the player character
     */
    public void generateMainDisplay(String[] gameState, Armor[] armorSet, Character player) {
        //Show Character info
        System.out.println(player.getImage() + "          Health: "
                + player.getHealth());
        System.out.println("Info:                    WPN: "
                + armorSet[0].getImage() + "\n" +
                "Gold: " + gameState[14] + " || Buff: " + gameState[6]
                + " || Debuff: " + gameState[7]);
    }

    /**
     * Generates the main output to keep that "game" feel.
     * @param gameState state of the current game
     * @param armorSet set of armor as necessary
     * @param player player character
     * @param enemy enemy character
     */
    public void generateBattleDisplay(String[] gameState, Armor[] armorSet, Character player, Character enemy) {
        System.out.println("Enemy Health: " + enemy.getHealth());
        System.out.println(enemy.getEnemyImage());
        generateMainDisplay(gameState, armorSet, player);
    }

    /**
     * Generates the option menu display.
     * @param prompt the initial prompt
     * @param options the list of options to print
     */
    public void generateOptionsMenu(String prompt, String[] options) {
        System.out.println("\n" + prompt);
        for(int i = 0; i < options.length; i++)
            System.out.print("| " + String.valueOf(i+1) + ": " + options[i] + " |");
        System.out.println();
    }
}
