package battlegame.model.factory;

import battlegame.model.Enemy;
import battlegame.model.action.*;

public class EnemyActionAssigner {

    public static void assignActions(Enemy enemy) {
        enemy.addAction(new BasicAttack());
        enemy.addAction(new StrongAttackDecorator(new BasicAttack()));
        enemy.addAction(new PoisonAttackDecorator(new BasicAttack()));
        enemy.addAction(new DoubleHitDecorator(new StrongAttackDecorator(new BasicAttack())));
        enemy.addAction(new DefensiveAction());

        System.out.println("[ASSIGNER] Acciones asignadas a " + enemy.getName());
    }
}
