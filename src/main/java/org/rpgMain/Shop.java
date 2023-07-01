package org.rpgMain;

import java.util.Scanner;

/**
 * General shop management system.
 * Start at the entrance and go to each section as necessary.
 */
public class Shop {

    /**
     * Primary entrance to the shop.
     * Provides options to travel to different parts of the shop.
     * @param gameState String array of the gameState
     * @param potions int array of all potions
     */
    public void enterShop(String[] gameState, int[] potions) {
        //Output the options
        DisplayOutput displayOutput = new DisplayOutput();
        String[] options = {"Buffs", "Potions", "Scrolls", "Exit Shop"};
        displayOutput.generateOptionsMenu("Please choose", options);
        //Take input from the player
        Scanner shopInput = new Scanner(System.in);
        String shopValue = shopInput.nextLine();
        System.out.println();
        //Perform requested action
        if (!shopValue.equals("")) {
            try {
                switch (Integer.parseInt(shopValue)) {
                    case 1:
                        purchaseBuffs(gameState, potions);
                        break;
                    case 2:
                        purchasePotions(gameState, potions);
                        break;
                    case 3:
                        purchaseScrolls(gameState, potions);
                        break;
                    case 4:
                        Main.returnHome();
                    default:
                        System.out.println("Incorrect choice.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect choice..");
            }
        } else
            System.out.println("Incorrect choice...");
    }


    /**
     * Provides a list of buff options to choose from.
     */
    private void purchaseBuffs(String[] gameState, int[] potions) {
        //Display options
        DisplayOutput displayOutput = new DisplayOutput();
        String[] options = {"Empowered", "Hastened", "Fortified", "Return"};
        displayOutput.generateOptionsMenu("Choose a buff (10,000 each):", options);
        //Take in user input
        Scanner shopInput = new Scanner(System.in);
        String shopValue = shopInput.nextLine();
        System.out.println();
        //Perform the requested action
        if(!shopValue.equals("")) {
            try {
                switch (Integer.parseInt(shopValue)) {
                    case 1:
                        if(Integer.parseInt(gameState[14]) < 10000) {
                            System.out.println("You do not have enough gold! :(");
                            return;
                        }
                        gameState[6] = "DMG+";
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 10000);
                        break;
                    case 2:
                        if(Integer.parseInt(gameState[14]) < 10000) {
                            System.out.println("You do not have enough gold! :(");
                            return;
                        }
                        gameState[6] = "SPD+";
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 10000);
                        break;
                    case 3:
                        if(Integer.parseInt(gameState[14]) < 10000) {
                            System.out.println("You do not have enough gold! :(");
                            return;
                        }
                        gameState[6] = "REG+";
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 10000);
                        break;
                    case 4:
                        enterShop(gameState, potions);
                        break;
                    default:
                        System.out.println("Incorrect choice.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect choice..");
            }
        } else
            System.out.println("Incorrect choice...");
    }


    /**
     * Provides a list of potion options to choose from.
     */
    private void purchasePotions(String[] gameState, int[] potions) {
        //Display options
        DisplayOutput displayOutput = new DisplayOutput();
        String[] options = {"Health", "Elixir", "Lovers", "Return"};
        displayOutput.generateOptionsMenu("Choose a potion (200 each):", options);
        //Take in user input
        Scanner shopInput = new Scanner(System.in);
        String shopValue = shopInput.nextLine();
        System.out.println();
        //Perform the requested action
        if(!shopValue.equals("")) {
            try {
                switch (Integer.parseInt(shopValue)) {
                    case 1:
                        if(Integer.parseInt(gameState[14]) < 200) {
                            System.out.println("You do not have enough gold! :(");
                            return;
                        }
                        potions[0]++;
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 200);
                        break;
                    case 2:
                        if(Integer.parseInt(gameState[14]) < 200) {
                            System.out.println("You do not have enough gold! :(");
                            return;
                        }
                        potions[1]++;
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 200);
                        break;
                    case 3:
                        if(Integer.parseInt(gameState[14]) < 200) {
                            System.out.println("You do not have enough gold! :(");
                            return;
                        }
                        System.out.println("Butterfly in the sky.");
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 200);
                        break;
                    case 4:
                        enterShop(gameState, potions);
                        break;
                    default:
                        System.out.println("Incorrect choice.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect choice..");
            }
        } else
            System.out.println("Incorrect choice...");
    }


    /**
     * Provides a list of scroll options to choose from.
     */
    private void purchaseScrolls(String[] gameState, int[] potions) {
        //Display options
        DisplayOutput displayOutput = new DisplayOutput();
        String[] options = {"+EXP", "+Accuracy", "+Gold", "Return"};
        displayOutput.generateOptionsMenu("Choose a scroll (100,000 each):", options);
        //Take in user input
        Scanner shopInput = new Scanner(System.in);
        String shopValue = shopInput.nextLine();
        System.out.println();
        //perform the requested action
        if(!shopValue.equals("")) {
            try {
                switch (Integer.parseInt(shopValue)) {
                    case 1:
                        if(Integer.parseInt(gameState[14]) < 100000) {
                            System.out.println("You do not have enough gold! :(");
                            return;
                        }
                        gameState[8] = "EXP+";
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 100000);
                        break;
                    case 2:
                        if(Integer.parseInt(gameState[14]) < 100000) {
                            System.out.println("You do not have enough gold! :(");
                            return;
                        }
                        gameState[8] = "ACC+";
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 100000);
                        break;
                    case 3:
                        if(Integer.parseInt(gameState[14]) < 100000) {
                            System.out.println("You do not have enough gold! :(");
                            return;
                        }
                        gameState[8] = "GLD+";
                        gameState[14] = String.valueOf(Integer.parseInt(gameState[14]) - 100000);
                        break;
                    case 4:
                        enterShop(gameState, potions);
                        break;
                    default:
                        System.out.println("Incorrect choice.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect choice..");
            }
        } else
            System.out.println("Incorrect choice...");
    }
}
