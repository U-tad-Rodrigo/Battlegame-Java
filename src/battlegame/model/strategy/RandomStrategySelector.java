package battlegame.model.strategy;

import java.util.List;
import java.util.Random;

public class RandomStrategySelector {
    private static final List<CombatStrategy> STRATEGIES = List.of(
        new RandomStrategy(),
        new AggressiveStrategy(),
        new DefensiveStrategy()
    );

    private static final Random random = new Random();

    public static CombatStrategy getRandomStrategy() {
        CombatStrategy selected = STRATEGIES.get(random.nextInt(STRATEGIES.size()));
        System.out.println("[STRATEGY] RandomStrategySelector -> Estrategia seleccionada: " + selected.getClass().getSimpleName());
        return selected;
    }
}
