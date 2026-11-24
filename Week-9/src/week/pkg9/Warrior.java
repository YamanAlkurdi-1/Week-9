/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week.pkg9;

/**
 *
 * @author LARTEK
 */

public class Warrior extends GameCharacter implements Attacker {

    private int armor;

    public Warrior(String name, int level, int maxHealth, int armor) {
        super(name, level, maxHealth);
        this.armor = armor;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 10 + armor * 2;
    }

    @Override
    public String getCharacterInfo() {
        return "Warrior: " + getName()
                + " | Level: " + getLevel()
                + " | Health: " + getHealth()
                + "/" + getMaxHealth()
                + " | Armor: " + armor
                + " | Power: " + calculatePower();
    }

    @Override
    public int takeDamage(int damage) {

        if (damage <= 0 || !isAlive()) {
            return 0;
        }

        int reducedDamage = damage - armor / 2;

        if (reducedDamage < 1) {
            reducedDamage = 1;
        }

        return super.takeDamage(reducedDamage);
    }

    @Override
    public int attack(GameCharacter target) {

        if (!isAlive()) {
            return 0;
        }

        if (target == null || !target.isAlive()) {
            return 0;
        }

        int damage = calculatePower() / 4;

        int actualDamage = target.takeDamage(damage);

        System.out.println(getName() + " attacks "
                + target.getName() + " and deals "
                + actualDamage + " damage.");

        return actualDamage;
    }
}

