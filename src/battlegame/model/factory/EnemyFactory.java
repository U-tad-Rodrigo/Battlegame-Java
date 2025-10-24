package battlegame.model.factory;

import battlegame.model.Enemy;

public interface EnemyFactory {
    Enemy createWarrior();
    Enemy createWizard();
    Enemy createMutant();
}
