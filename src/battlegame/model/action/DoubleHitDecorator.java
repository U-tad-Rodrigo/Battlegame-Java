package battlegame.model.action;

import battlegame.model.Character;
import battlegame.model.state.CharacterState;
import battlegame.model.state.InjuredState;
import battlegame.model.state.NormalState;
import battlegame.model.state.ParalyzedState;

public class DoubleHitDecorator extends ActionDecorator {

    public DoubleHitDecorator(Action action) {
        super(action);
    }

    @Override
    public void execute(Character source, Character target) {
        System.out.println("[ACTION] Ejecutando DoubleHit: se aplicará estado y luego dos ataques.");
        this.setState(target);
        action.execute(source, target);
        System.out.println("[ACTION] Segundo golpe de DoubleHit...");
        action.execute(source, target);
    }
    
    @Override
    public int getPowerLevel() {
        return action.getPowerLevel() + 3;
    }

    @Override
    public void setState(Character target) {
        int randNum = (int)(Math.random() * 100) + 1;
        CharacterState state;

        if (randNum <= 40) {
            state = new InjuredState();
        } else if (randNum <= 80) {
            state = new ParalyzedState();
        } else {
            state = new NormalState();
        }

        System.out.println("[ACTION] DoubleHitDecorator -> Random: " + randNum + " -> Estado aplicado: " + state.getClass().getSimpleName());

        state.handle(target);
        target.setState(state);
    }

	@Override
	public String getName() {
		return "Double Hit Attack";
	}
}
