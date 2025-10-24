package battlegame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import battlegame.model.action.Action;

public class Player extends Character {
    
    private List<Action> actions;

    public Player(String name, int health, int strength, int agility, int resistance) {
        super(name, health, strength, agility, resistance);
        this.actions = new ArrayList<>();
    }
    
    public void addAction(Action action) {
        actions.add(action);
        System.out.println("[PLAYER] Acción añadida al jugador: " + action.getClass().getSimpleName());
    }

    @Override
    public void performAction(Character opponent) {
        if (actions.isEmpty()) {
            System.out.println("[PLAYER] No tienes acciones disponibles para usar!");
            return;
        }

        this.setDefending(false);
        System.out.println("\n--- Tu turno ---");
        System.out.println("Elige una acción:");

        for (int i = 0; i < actions.size(); i++) {
            System.out.println((i + 1) + ". " + actions.get(i).getName());
        }

        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice < 1 || choice > actions.size()) {
            System.out.print("Introduce el número de la acción: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.next();
            }
        }

        Action selectedAction = actions.get(choice - 1);
        System.out.println("[PLAYER] Acción seleccionada por el jugador: " + selectedAction.getClass().getSimpleName());
        selectedAction.execute(this, opponent);
    }

    public List<Action> getActions() {
        return actions;
    }
}
