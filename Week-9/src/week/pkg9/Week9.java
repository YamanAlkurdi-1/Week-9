/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week.pkg9;

/**
 *
 * @author LARTEK
 */
public class Week9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Team team = new Team();

        // Creating characters

        Warrior warrior = new Warrior("Thor", 10, 200, 20);

        Mage mage = new Mage("Merlin", 8, 120, 100);

        Healer healer = new Healer("Angel", 7, 150, 30);

        // Adding characters to team

        team.addCharacter(warrior);
        team.addCharacter(mage);
        team.addCharacter(healer);

        // Testing duplicate name

        Warrior duplicate = new Warrior("Thor", 5, 100, 10);

        team.addCharacter(duplicate);

        // Testing invalid level

        Mage invalid = new Mage("Test", 150, 100, 50);

        // Creating enemy

        Warrior enemy = new Warrior("Golem", 20, 500, 10);

        System.out.println("\n========== BATTLE START ==========");

        // Two battle rounds

        for (int round = 1; round <= 2; round++) {

            System.out.println("\n========== ROUND " + round + " ==========");

            // Team attacks enemy

            System.out.println("\n--- Team Attacks ---");

            team.attackAll(enemy);

            // Enemy attacks team members

            System.out.println("\n--- Enemy Attacks ---");

            if (enemy.isAlive()) {

                if (round == 1) {
                    enemy.attack(warrior);
                } else {
                    enemy.attack(mage);
                }
            }

            // Team heals itself

            System.out.println("\n--- Team Healing ---");

            team.healTeam();

            // Display battle status

            team.displayTeam();

            System.out.println("Enemy Health: "
                    + enemy.getHealth() + "/" + enemy.getMaxHealth());

            if (!enemy.isAlive()) {
                System.out.println("Enemy defeated!");
                break;
            }
        }

        // Removing a character

        System.out.println("\n========== REMOVE CHARACTER ==========");

        team.removeCharacter("Merlin");

        // Searching for a character

        System.out.println("\n========== SEARCH CHARACTER ==========");

        GameCharacter found = team.findByName("Thor");

        if (found != null) {
            System.out.println("Character found:");
            System.out.println(found.getCharacterInfo());
        } else {
            System.out.println("Character not found!");
        }

        // Final team display

        System.out.println("\n========== FINAL TEAM ==========");

        team.displayTeam();

        System.out.println("\n========== BATTLE END ==========");
    }
    }
    

