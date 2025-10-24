package battlegame.controller;

import battlegame.model.Player;
import battlegame.model.action.*;
import battlegame.model.factory.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameHandler {

    private static GameHandler instance;
    private Player player;
    private List<EnemyFactory> factories;

    private GameHandler() {}

    public static GameHandler getInstance() {
        if (instance == null) {
            instance = new GameHandler();
            System.out.println("[DEBUG] GameHandler instanciado");
        }
        return instance;
    }

    public void createPlayer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nombre del jugador:");
        String name = scanner.nextLine();

        System.out.println("Vida inicial:");
        int health = scanner.nextInt();

        System.out.println("Fuerza:");
        int strength = scanner.nextInt();

        System.out.println("Agilidad:");
        int agility = scanner.nextInt();

        System.out.println("Resistencia:");
        int resistance = scanner.nextInt();

        player = new Player(name, health, strength, agility, resistance);
        System.out.println("[HANDLER] Jugador creado con atributos - Vida: " + health + ", Fuerza: " + strength + ", Agilidad: " + agility + ", Resistencia: " + resistance);

        player.addAction(new BasicAttack());
        player.addAction(new StrongAttackDecorator(new BasicAttack()));
        player.addAction(new PoisonAttackDecorator(new BasicAttack()));
        player.addAction(new DoubleHitDecorator(new StrongAttackDecorator(new BasicAttack())));
        player.addAction(new DefensiveAction());
    }

    public void createFactories() {
        factories = new ArrayList<>();
        factories.add(new JungleEnemyFactory());
        factories.add(new OceanEnemyFactory());
        factories.add(new DesertEnemyFactory());
        System.out.println("[HANDLER] Fábricas de enemigos creadas: " + factories.size());
    }

    public void startGame() {
        if (player == null || factories == null) {
            System.out.println("[ERROR] El jugador o las fábricas no han sido creadas. Llama a createPlayer() y createFactories() antes.");
            return;
        }

        GameController controller = new GameController(player, factories);
        controller.startGame();
    }
}
