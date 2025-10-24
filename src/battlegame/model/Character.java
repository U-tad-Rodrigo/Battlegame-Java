package battlegame.model;

import battlegame.model.state.CharacterState;
import battlegame.model.state.NormalState;
import battlegame.model.state.ParalyzedState;

public abstract class Character {
	
	protected String name;
    protected int health;
    protected int strength;
    protected int agility;
    protected int resistance;
    
    private final int baseAgility;
    private final int baseResistance;
    private final int baseStrength;
    
    protected CharacterState state;

    private boolean defending = false;
    
    public Character(String name, int health, int strength, int agility, int resistance) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.resistance = resistance;
        this.baseAgility = agility;
        this.baseResistance = resistance;
        this.baseStrength = strength;
        this.state = new NormalState();
    }
    
    public abstract void performAction(Character opponent);
    
    public void receiveDamage(int damage) {
        if (defending) {
            damage = (int) (damage * 0.9);
            System.out.println("[CHARACTER] " + name + " está defendiendo. Daño reducido.");
        }

        this.health -= damage;
        if (this.health < 0) this.health = 0;

        System.out.println("[CHARACTER] " + this.name + " recibe " + damage + " de daño. Vida restante: " + this.health);
    }

    public void heal(int amount) {
        this.health += amount;
        System.out.println("[CHARACTER] " + name + " se cura " + amount + " puntos. Vida actual: " + health);
    }
    
    public boolean isAlive() {
        return this.health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getResistance() {
        return resistance;
    }

    public int getBaseAgility() {
        return baseAgility;
    }

    public int getBaseResistance() {
        return baseResistance;
    }

    public int getBaseStrength() {
        return baseStrength;
    }

    public CharacterState getState() {
        return state;
    }

    public void setState(CharacterState state) {
        this.state = state;
        System.out.println("[CHARACTER] Estado de " + name + " actualizado a: " + state.getClass().getSimpleName());
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public boolean isParalyzed() {
        return (this.state instanceof ParalyzedState);
    }

    public void setDefending(boolean state) {
        this.defending = state;
    }

    public boolean checkDefending() {
        return this.defending;
    }
}
