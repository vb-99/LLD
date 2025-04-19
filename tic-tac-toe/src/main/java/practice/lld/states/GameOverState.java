package practice.lld.states;

import practice.lld.GameContext;

public class GameOverState implements GameState{

    @Override
    public void next(GameContext context) {
        System.out.println("Game Over");
    }
}
