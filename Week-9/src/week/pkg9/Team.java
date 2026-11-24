/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week.pkg9;

import java.util.ArrayList;

/**
 *
 * @author LARTEK
 */
public class Team {

    private ArrayList<GameCharacter> characters;

    public Team() {
        characters = new ArrayList<>();
    }

    public void addCharacter(GameCharacter character) {

        if (character == null) {
            return;
        }

        if (findByName(character.getName()) != null) {
            System.out.println("Duplicate character name!");
            return;
        }

        characters.add(character);

        System.out.println(character.getName() + " added to team.");
    }

    public void removeCharacter(String name) {

        GameCharacter character = findByName(name);

        if (character != null) {
            characters.remove(character);
            System.out.println(name + " removed from team.");
        } else {
            System.out.println("Character not found!");
        }
    }

    public GameCharacter findByName(String name) {

        for (GameCharacter character : characters) {

            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }

        return null;
    }

    public void attackAll(GameCharacter target) {

        if (target == null || !target.isAlive()) {
            System.out.println("Invalid target!");
            return;
        }

        for (GameCharacter character : characters) {

            if (character.isAlive() && character instanceof Attacker) {

                Attacker attacker = (Attacker) character;

                attacker.attack(target);
            }

            if (!target.isAlive()) {
                System.out.println(target.getName() + " has been defeated!");
                break;
            }
        }
    }

    public void healTeam() {

        for (GameCharacter healer : characters) {

            if (healer.isAlive() && healer instanceof Supporter) {

                GameCharacter weakest = null;

                double lowestRatio = Double.MAX_VALUE;

                for (GameCharacter member : characters) {

                    if (member.isAlive()) {

                        double ratio = (double) member.getHealth()
                                / member.getMaxHealth();

                        if (ratio < lowestRatio) {
                            lowestRatio = ratio;
                            weakest = member;
                        }
                    }
                }

                if (weakest != null) {

                    Supporter supporter = (Supporter) healer;

                    supporter.heal(weakest);
                }
            }
        }
    }

    public int getTotalPower() {

        int totalPower = 0;

        for (GameCharacter character : characters) {

            if (character.isAlive()) {
                totalPower += character.calculatePower();
            }
        }

        return totalPower;
    }

    public void displayTeam() {

        System.out.println("\n========== TEAM MEMBERS ==========");

        for (GameCharacter character : characters) {

            System.out.println(character.getCharacterInfo());
        }

        System.out.println("Total Team Power: " + getTotalPower());

        System.out.println("==================================");
    }
}