/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week.pkg9;

/**
 *
 * @author LARTEK
 */

public abstract class GameCharacter {

    private String name;
    private int level;
    private int health;
    private int maxHealth;

    public GameCharacter(String name, int level, int maxHealth) {

        this.name = name;

        if (level < 1 || level > 100) {
            System.out.println("Invalid level! Set to 1.");
            this.level = 1;
        } else {
            this.level = level;
        }

        if (maxHealth <= 0) {
            System.out.println("Invalid maxHealth! Set to 100.");
            this.maxHealth = 100;
        } else {
            this.maxHealth = maxHealth;
        }

        this.health = this.maxHealth;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int takeDamage(int damage) {

        if (damage <= 0 || !isAlive()) {
            return 0;
        }

        int actualDamage = Math.min(damage, health);

        health -= actualDamage;

        return actualDamage;
    }

    public int restoreHealth(int amount) {

        if (amount <= 0 || !isAlive()) {
            return 0;
        }

        int actualRestore = Math.min(amount, maxHealth - health);

        health += actualRestore;

        return actualRestore;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public abstract String getCharacterInfo();

    public abstract int calculatePower();
}

