package battlegame.model.state;

import battlegame.model.Character;

public class RecoveringState implements CharacterState {

    @Override
    public void handle(Character character) {
    	System.out.println("[STATE] " + character.getName() + " se está recuperando vida.");
        character.heal(10);
    }
}
