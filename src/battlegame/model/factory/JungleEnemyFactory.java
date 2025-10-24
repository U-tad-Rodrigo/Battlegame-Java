package battlegame.model.factory;

import battlegame.enums.EnemyType;
import battlegame.enums.WorldType;
import battlegame.model.Enemy;
import battlegame.model.strategy.RandomStrategySelector;

public class JungleEnemyFactory implements EnemyFactory {

    @Override
    public Enemy createWarrior() {
        System.out.println("[FACTORY] JungleEnemyFactory -> Creando Guerrero de la Jungla");
        return new Enemy("Guerrero de la Jungla", 100, 25, 10, 5,
                RandomStrategySelector.getRandomStrategy(), EnemyType.WARRIOR, WorldType.JUNGLE);
    }

    @Override
    public Enemy createWizard() {
        System.out.println("[FACTORY] JungleEnemyFactory -> Creando Hechicero de la Jungla");
        return new Enemy("Hechicero de la Jungla", 80, 15, 20, 8,
                RandomStrategySelector.getRandomStrategy(), EnemyType.WIZARD, WorldType.JUNGLE);
    }

    @Override
    public Enemy createMutant() {
        System.out.println("[FACTORY] JungleEnemyFactory -> Creando Mutante de la Jungla");
        return new Enemy("Mutante de la Jungla", 120, 30, 5, 12,
                RandomStrategySelector.getRandomStrategy(), EnemyType.MUTANT, WorldType.JUNGLE);
    }
}
