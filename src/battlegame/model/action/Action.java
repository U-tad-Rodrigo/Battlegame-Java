package battlegame.model.action;

import battlegame.model.Character;

public interface Action {
    void execute(Character source, Character target);
    void setState(Character target);
    int getPowerLevel();
    String getName();
}
