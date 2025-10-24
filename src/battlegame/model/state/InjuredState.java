package battlegame.model.state;
import battlegame.model.Character;

public class InjuredState implements CharacterState {

    @Override
    public void handle(Character character) {
    	System.out.println("[STATE] " + character.getName() + " ha sido herido!");
        character.setStrength(character.getStrength() - 1);
        character.setAgility(character.getAgility() - 1);
        character.setResistance(character.getResistance()-1);
    }
}
