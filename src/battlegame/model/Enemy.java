package battlegame.model;

import battlegame.enums.EnemyType;
import battlegame.enums.WorldType;
import battlegame.model.action.Action;
import battlegame.model.strategy.CombatStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Enemy extends Character {

    private final CombatStrategy strategy;
    private final EnemyType enemyType;
    private final WorldType worldType;
    private final List<Action> actions;

    public Enemy(String name, int health, int strength, int agility, int resistance,
                 CombatStrategy strategy, EnemyType enemyType, WorldType worldType) {
        super(name, health, strength, agility, resistance);
        this.strategy = strategy;
        this.enemyType = enemyType;
        this.worldType = worldType;
        this.actions = new ArrayList<>();
        System.out.println("[DEBUG] Enemigo creado: " + name + " [" + worldType + ", " + enemyType + "]");
    }

    @Override
    public void performAction(Character opponent) {
        System.out.println("\n--- Turno del enemigo: " + this.name + " ---");
        this.setDefending(false);

        if (this.isParalyzed()) {
            System.out.println("[ENEMY] " + this.name + " está paralizado y pierde el turno.");
            return;
        }

        Action chosenAction = decideNextAction(opponent);
        chosenAction.execute(this, opponent);
    }

    protected Action decideNextAction(Character opponent) {
        return strategy.chooseAction(this, opponent);
    }

    public void addAction(Action action) {
        System.out.println("[ENEMY] Añadiendo acción: " + action.getClass().getSimpleName() + " al enemigo " + this.name);
        actions.add(action);
        actions.sort(Comparator.comparingInt(Action::getPowerLevel));

        System.out.print("[ENEMY] Acciones ordenadas por powerLevel: ");
        for (Action a : actions) {
            System.out.print(a.getClass().getSimpleName() + "(" + a.getPowerLevel() + ") ");
        }
        System.out.println();
    }

    public List<Action> getActions() {
        return actions;
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public WorldType getWorldType() {
        return worldType;
    }

    public CombatStrategy getStrategy() {
        return strategy;
    }
}
