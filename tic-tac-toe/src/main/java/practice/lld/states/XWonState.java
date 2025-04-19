package practice.lld.states;

import practice.lld.GameContext;

public class XWonState implements GameState {
    @Override
    public void next(GameContext context) {
        System.out.println("X Won");
        context.setCurrentState(new GameOverState());
    }
}
