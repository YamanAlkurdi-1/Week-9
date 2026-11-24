/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week.pkg9;

/**
 *
 * @author LARTEK
 */

public class Mage extends GameCharacter implements Attacker, Supporter {

    private int mana;

    public Mage(String name, int level, int maxHealth, int mana) {
        super(name, level, maxHealth);
        this.mana = mana;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 8 + mana;
    }

    @Override
    public String getCharacterInfo() {
        return "Mage: " + getName()
                + " | Level: " + getLevel()
                + " | Health: " + getHealth()
                + "/" + getMaxHealth()
                + " | Mana: " + mana
                + " | Power: " + calculatePower();
    }

    @Override
    public int attack(GameCharacter target) {

        if (!isAlive() || target == null || !target.isAlive()) {
            return 0;
        }

        if (mana < 20) {
            System.out.println(getName() + " does not have enough mana!");
            return 0;
        }

        int power = calculatePower();

        int damage = power / 3;

        mana -= 20;

        int actualDamage = target.takeDamage(damage);

        System.out.println(getName() + " attacks "
                + target.getName() + " and deals "
                + actualDamage + " damage.");

        return actualDamage;
    }

    @Override
    public int heal(GameCharacter target) {

        if (!isAlive() || target == null || !target.isAlive()) {
            return 0;
        }

        if (mana < 15) {
            System.out.println(getName() + " does not have enough mana!");
            return 0;
        }

        mana -= 15;

        int restored = target.restoreHealth(getLevel() * 2);

        System.out.println(getName() + " heals "
                + target.getName() + " for "
                + restored + " health.");

        return restored;
    }
}
