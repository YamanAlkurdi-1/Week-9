/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week.pkg9;

/**
 *
 * @author LARTEK
 */

public class Healer extends GameCharacter implements Supporter {

    private int healAmount;

    public Healer(String name, int level, int maxHealth, int healAmount) {
        super(name, level, maxHealth);
        this.healAmount = healAmount;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 5 + healAmount;
    }

    @Override
    public String getCharacterInfo() {
        return "Healer: " + getName()
                + " | Level: " + getLevel()
                + " | Health: " + getHealth()
                + "/" + getMaxHealth()
                + " | Heal Amount: " + healAmount
                + " | Power: " + calculatePower();
    }

    @Override
    public int heal(GameCharacter target) {

        if (!isAlive() || target == null || !target.isAlive()) {
            return 0;
        }

        int restored = target.restoreHealth(healAmount + getLevel());

        System.out.println(getName() + " heals "
                + target.getName() + " for "
                + restored + " health.");

        return restored;
    }
}

