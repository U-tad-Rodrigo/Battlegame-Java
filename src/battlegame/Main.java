package battlegame;

import battlegame.model.Player;
import battlegame.model.factory.EnemyFactory;
import battlegame.controller.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameHandler handler = GameHandler.getInstance();

        handler.createPlayer();
        handler.createFactories();

        handler.startGame();
    }
}
