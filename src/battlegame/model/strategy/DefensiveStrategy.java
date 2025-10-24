package battlegame.model.strategy;

import battlegame.model.Character;
import battlegame.model.Enemy;
import battlegame.model.action.Action;

import java.util.List;

public class DefensiveStrategy implements CombatStrategy {

    @Override
    public Action chooseAction(Enemy enemy, Character opponent) {
        List<Action> actions = enemy.getActions();

        if (!actions.isEmpty()) {
            Action weakest = actions.get(0);

            for (Action action : actions) {
                if (action.getPowerLevel() < weakest.getPowerLevel()) {
                    weakest = action;
                }
            }

            enemy.setDefending(true);
            System.out.println("[STRATEGY] DefensiveStrategy -> Acción elegida: " + weakest.getClass().getSimpleName() + " (PowerLevel: " + weakest.getPowerLevel() + ")");
            System.out.println("[STRATEGY] Defensa activada para " + enemy.getName());
            return weakest;
        }

        System.out.println("[STRATEGY] DefensiveStrategy -> Lista vacía, usando BasicAttack.");
        enemy.setDefending(false);
        return new battlegame.model.action.BasicAttack();
    }
}
