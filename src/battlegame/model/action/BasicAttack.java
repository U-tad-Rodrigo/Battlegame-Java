package battlegame.model.action;

import battlegame.model.Character;
import battlegame.model.state.CharacterState;
import battlegame.model.state.InjuredState;
import battlegame.model.state.NormalState;
import battlegame.model.state.ParalyzedState;
import battlegame.service.DamageCalculator;

public class BasicAttack implements Action {
	
	
	public String getName() {
		return "Defensive Action";
	}

    @Override
    public void execute(Character source, Character target) {
        int damage = DamageCalculator.getInstance().calculateDamage(this, source, target);
        System.out.println("[ACTION] Daño base calculado por BasicAttack: " + damage);

        this.setState(target);

        if (target.getState() instanceof InjuredState) {
            damage += 5;
            System.out.println("[ACTION] Bonus por estado 'InjuredState': +5 de daño.");
        }

        target.receiveDamage(damage);
    }

    @Override
    public int getPowerLevel() {
        return 1;
    }

    @Override
    public void setState(Character target) {
        int randNum = (int)(Math.random() * 100) + 1;
        CharacterState state;

        if (randNum <= 40) {
            state = new InjuredState();
        } else if (randNum <= 70) {
            state = new ParalyzedState();
        } else {
            state = new NormalState();
        }

        System.out.println("[ACTION] Random generado: " + randNum + " -> Estado aplicado: " + state.getClass().getSimpleName());
        state.handle(target);
        target.setState(state);
    }
}
