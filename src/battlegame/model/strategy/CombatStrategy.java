package battlegame.model.strategy;

import battlegame.model.Character;
import battlegame.model.Enemy;
import battlegame.model.action.Action;

public interface CombatStrategy {
    Action chooseAction(Enemy enemy, Character opponent);
}
