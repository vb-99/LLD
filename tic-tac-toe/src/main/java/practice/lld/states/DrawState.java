package practice.lld.states;

import practice.lld.GameContext;

public class DrawState implements GameState {

    @Override
    public void next(GameContext context) {
        System.out.println("Match Draw");
    }
}
