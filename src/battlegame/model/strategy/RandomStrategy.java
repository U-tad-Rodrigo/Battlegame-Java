package battlegame.model.strategy;

import battlegame.model.Character;
import battlegame.model.Enemy;
import battlegame.model.action.Action;

import java.util.List;
import java.util.Random;

public class RandomStrategy implements CombatStrategy {

    private final Random random = new Random();

    @Override
    public Action chooseAction(Enemy enemy, Character opponent) {
        List<Action> actions = enemy.getActions();

        if (!actions.isEmpty()) {
            Action randomAction = actions.get(random.nextInt(actions.size()));
            System.out.println("[STRATEGY] RandomStrategy -> Acción aleatoria elegida: " + randomAction.getClass().getSimpleName());
            return randomAction;
        }

        System.out.println("[STRATEGY] RandomStrategy -> Lista de acciones vacía, usando BasicAttack.");
        return new battlegame.model.action.BasicAttack();
    }
}
