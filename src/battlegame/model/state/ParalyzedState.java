package battlegame.model.state;

import battlegame.model.Character;

public class ParalyzedState implements CharacterState {

    @Override
    public void handle(Character character) {
        System.out.println("[STATE]" + character.getName() + " está paralizado.");
    }
}
