package battlegame.model.state;

import battlegame.model.Character;

public class NormalState implements CharacterState {

    @Override
    public void handle(Character character) {
    	System.out.println("[STATE] " + character.getName() + " está en estado normal");
    	character.setAgility(character.getBaseAgility());
        character.setResistance(character.getBaseResistance());
        character.setStrength(character.getBaseStrength());
    }
}
