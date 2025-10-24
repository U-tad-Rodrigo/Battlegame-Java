package battlegame.model.action;

import battlegame.model.Character;

public class DefensiveAction implements Action {

    private BasicAttack attack = new BasicAttack();

    @Override
    public void execute(Character user, Character target) {
        System.out.println(user.getName() + " ataca y se defiende");
        attack.execute(user, target);
        user.setDefending(true);
        System.out.println("[ACTION] " + user.getName() + " ha activado el modo defensa.");
    }

    @Override
    public void setState(Character target) {

    }

    @Override
    public int getPowerLevel() {
        return attack.getPowerLevel();
    }

	@Override
	public String getName() {
		
		return "Defensive Action";
	}
}
