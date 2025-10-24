package battlegame.model.strategy;

import battlegame.model.Character;
import battlegame.model.Enemy;
import battlegame.model.action.Action;

import java.util.List;

public class AggressiveStrategy implements CombatStrategy {

    @Override
    public Action chooseAction(Enemy enemy, Character opponent) {
        List<Action> actions = enemy.getActions();

        if (!actions.isEmpty()) {
            Action strongest = actions.get(0);

            for (Action action : actions) {
                if (action.getPowerLevel() > strongest.getPowerLevel()) {
                    strongest = action;
                }
            }

            System.out.println("[STRATEGY] AggressiveStrategy -> Acción seleccionada: " + strongest.getClass().getSimpleName() + " (PowerLevel: " + strongest.getPowerLevel() + ")");
            return strongest;
        }

        System.out.println("[STRATEGY] AggressiveStrategy -> Lista de acciones vacía, usando BasicAttack por defecto.");
        return new battlegame.model.action.BasicAttack();
    }
}
