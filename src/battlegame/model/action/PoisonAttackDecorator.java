package battlegame.model.action;

import battlegame.model.Character;
import battlegame.model.state.CharacterState;
import battlegame.model.state.InjuredState;
import battlegame.model.state.NormalState;
import battlegame.model.state.ParalyzedState;
import battlegame.service.DamageCalculator;

public class PoisonAttackDecorator extends ActionDecorator {

    public PoisonAttackDecorator(Action action) {
        super(action);
    }

    @Override
    public void execute(Character source, Character target) {
        int baseDamage = DamageCalculator.getInstance().calculateDamage(action, source, target);
        int poisonDamage = 5;
        System.out.println("[ACTION] PoisonAttack -> Daño base: " + baseDamage + ", bonus de veneno: +" + poisonDamage);

        this.setState(target);
        target.receiveDamage(baseDamage + poisonDamage);
    }

    @Override
    public int getPowerLevel() {
        return action.getPowerLevel() + 1;
    }

    @Override
    public void setState(Character target) {
        int randNum = (int)(Math.random() * 100) + 1;
        CharacterState state;

        if (randNum <= 30) {
            state = new InjuredState();
        } else if (randNum <= 70) {
            state = new ParalyzedState();
        } else {
            state = new NormalState();
        }

        System.out.println("[ACTION] PoisonAttackDecorator -> Random: " + randNum + " -> Estado aplicado: " + state.getClass().getSimpleName());

        state.handle(target);
        target.setState(state);
    }

	@Override
	public String getName() {
		return "Poison Attack";
	}
}
