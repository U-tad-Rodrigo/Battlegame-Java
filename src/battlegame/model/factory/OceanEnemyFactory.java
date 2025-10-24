package battlegame.model.factory;

import battlegame.enums.EnemyType;
import battlegame.enums.WorldType;
import battlegame.model.Enemy;
import battlegame.model.strategy.RandomStrategySelector;

public class OceanEnemyFactory implements EnemyFactory {

    @Override
    public Enemy createWarrior() {
        System.out.println("[FACTORY] OceanEnemyFactory -> Creando Guerrero del Océano");
        return new Enemy("Guerrero del Océano", 110, 20, 12, 10,
                RandomStrategySelector.getRandomStrategy(), EnemyType.WARRIOR, WorldType.OCEAN);
    }

    @Override
    public Enemy createWizard() {
        System.out.println("[FACTORY] OceanEnemyFactory -> Creando Hechicero del Océano");
        return new Enemy("Hechicero del Océano", 85, 18, 22, 9,
                RandomStrategySelector.getRandomStrategy(), EnemyType.WIZARD, WorldType.OCEAN);
    }

    @Override
    public Enemy createMutant() {
        System.out.println("[FACTORY] OceanEnemyFactory -> Creando Mutante del Océano");
        return new Enemy("Mutante del Océano", 130, 28, 8, 14,
                RandomStrategySelector.getRandomStrategy(), EnemyType.MUTANT, WorldType.OCEAN);
    }
}
