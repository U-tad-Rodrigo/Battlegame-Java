package battlegame.service;

import battlegame.model.Character;
import battlegame.model.action.Action;

public class DamageCalculator {

    private static final DamageCalculator instance = new DamageCalculator();

    private DamageCalculator() {}

    public static DamageCalculator getInstance() {
        return instance;
    }

    public int calculateDamage(Action action, Character source, Character target) {
        int base = source.getStrength();
        int modifier = source.getAgility() / 4;
        int resistance = target.getResistance();
        int rawDamage = base + modifier;
        int finalDamage = Math.max(0, rawDamage - resistance);

        System.out.println("[DAMAGE] DamageCalculator -> Base: " + base + ", Agilidad/4: " + modifier + ", Resistencia objetivo: " + resistance);
        System.out.println("[DAMAGE] DamageCalculator -> Daño final aplicado: " + finalDamage);

        return finalDamage;
    }
}
