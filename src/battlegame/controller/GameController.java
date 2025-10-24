package battlegame.controller;

import battlegame.enums.EnemyType;
import battlegame.model.Enemy;
import battlegame.model.Player;
import battlegame.model.factory.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {

    private Player player;
    private List<EnemyFactory> factories;
    private int score;

    public GameController(Player player, List<EnemyFactory> factories) {
        this.player = player;
        this.factories = factories;
        this.score = 0;
        System.out.println("[GAMECONTROLLER] GameController creado con 3 fábricas de enemigos.");
    }

    public void startGame() {
        Random random = new Random();
        boolean isPlayerTurn = random.nextBoolean();
        System.out.println("[GAMECONTROLLER] ¿Empieza el jugador? " + isPlayerTurn);
        boolean bucle = true;

        while (bucle) {
            Enemy enemy = generateRandomEnemy();
            System.out.println("\n[GAMECONTROLLER] Enemigo generado: " + enemy.getName());

            while (player.isAlive() && enemy.isAlive()) {
                if (isPlayerTurn) {
                    System.out.println("[GAMECONTROLLER] Turno del jugador.");
                    if (!player.isParalyzed()) {
                        player.performAction(enemy);
                    } else {
                        System.out.println("\n--- Tu turno ---");
                        System.out.println("[GAMECONTROLLER] "+ player.getName() + " está paralizado y pierde el turno.");
                    }
                } else {
                    System.out.println("[GAMECONTROLLER] Turno del enemigo.");
                    if (!enemy.isParalyzed()) {
                        enemy.performAction(player);
                    } else {
                        System.out.println("\n--- Turno del enemigo: " + enemy.getName() + " ---");
                        System.out.println("[GAMECONTROLLER] "+ enemy.getName() + " está paralizado y pierde el turno.");
                    }
                }
                isPlayerTurn = !isPlayerTurn;
            }

            if (!player.isAlive()) {
                System.out.println("[GAMECONTROLLER] El jugador ha muerto.");
                System.out.println("[GAMECONTROLLER] Has sido derrotado. Fin del juego. Puntos obtenidos: " + score);
                bucle = false;
            } else {
                score++;
                System.out.println("[GAMECONTROLLER] Enemigo derrotado. Puntos actuales: " + score);
            }
        }
    }

    private Enemy generateRandomEnemy() {
        Random rand = new Random();
        EnemyFactory factory = factories.get(rand.nextInt(factories.size()));
        EnemyType type = EnemyType.values()[rand.nextInt(EnemyType.values().length)];
        System.out.println("[GAMECONTROLLER] Generando enemigo tipo " + type + " con fábrica " + factory.getClass().getSimpleName());

        switch (type) {
            case WARRIOR:
                return factory.createWarrior();
            case WIZARD:
                return factory.createWizard();
            case MUTANT:
                return factory.createMutant();
            default:
                return factory.createWarrior();
        }
    }
}
