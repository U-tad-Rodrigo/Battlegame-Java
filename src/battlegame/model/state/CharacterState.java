package battlegame.model.state;
import battlegame.model.Character;

public interface CharacterState {
    void handle(Character character);
}
