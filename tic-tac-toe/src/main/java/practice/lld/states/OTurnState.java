package practice.lld.states;

import practice.lld.GameContext;

public class OTurnState implements GameState {
    @Override
    public void next(GameContext context) {
        System.out.println("Player with symbol X turn");
        context.setCurrentState(new XTurnState());
    }
}
