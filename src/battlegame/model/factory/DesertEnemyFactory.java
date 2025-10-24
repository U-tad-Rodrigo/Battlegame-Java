package battlegame.model.factory;

import battlegame.enums.EnemyType;
import battlegame.enums.WorldType;
import battlegame.model.Enemy;
import battlegame.model.strategy.RandomStrategySelector;

public class DesertEnemyFactory implements EnemyFactory {

    @Override
    public Enemy createWarrior() {
        System.out.println("[FACTORY] DesertEnemyFactory -> Creando Guerrero del Desierto");
        Enemy enemy = new Enemy("Guerrero del Desierto", 95, 22, 14, 7,
                RandomStrategySelector.getRandomStrategy(), EnemyType.WARRIOR, WorldType.DESERT);
        EnemyActionAssigner.assignActions(enemy);
        return enemy;
    }

    @Override
    public Enemy createWizard() {
        System.out.println("[FACTORY] DesertEnemyFactory -> Creando Hechicero del Desierto");
        Enemy enemy = new Enemy("Hechicero del Desierto", 75, 17, 25, 6,
                RandomStrategySelector.getRandomStrategy(), EnemyType.WIZARD, WorldType.DESERT);
        EnemyActionAssigner.assignActions(enemy);
        return enemy;
    }

    @Override
    public Enemy createMutant() {
        System.out.println("[FACTORY] DesertEnemyFactory -> Creando Mutante del Desierto");
        Enemy enemy = new Enemy("Mutante del Desierto", 110, 26, 9, 11,
                RandomStrategySelector.getRandomStrategy(), EnemyType.MUTANT, WorldType.DESERT);
        EnemyActionAssigner.assignActions(enemy);
        return enemy;
    }
}
