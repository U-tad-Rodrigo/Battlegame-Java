package battlegame.model.action;

import battlegame.model.Character;
import battlegame.model.state.CharacterState;
import battlegame.model.state.InjuredState;
import battlegame.model.state.NormalState;
import battlegame.model.state.ParalyzedState;
import battlegame.service.DamageCalculator;

public class StrongAttackDecorator extends ActionDecorator {

    public StrongAttackDecorator(Action action) {
        super(action);
    }

    @Override
    public void execute(Character source, Character target) {
        int baseDamage = DamageCalculator.getInstance().calculateDamage(action, source, target);
        int bonus = source.getStrength() / 2;

        System.out.println("[ACTION] StrongAttack -> Daño base: " + baseDamage + ", bonus por fuerza: +" + bonus);

        this.setState(target);
        target.receiveDamage(baseDamage + bonus);
    }

    @Override
    public int getPowerLevel() {
        return action.getPowerLevel() + 2;
    }

    @Override
    public void setState(Character target) {
        int randNum = (int)(Math.random() * 100) + 1;
        CharacterState state;

        if (randNum <= 10) {
            state = new ParalyzedState();
        } else if (randNum <= 60) {
            state = new InjuredState();  
        } else {
            state = new NormalState();   
        }

        System.out.println("[ACTION] StrongAttackDecorator -> Random: " + randNum + " -> Estado aplicado: " + state.getClass().getSimpleName());

        state.handle(target);
        target.setState(state);
    }

	@Override
	public String getName() {
		return "Strong Attack";
	}
}
