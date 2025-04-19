package practice.lld.states;

import practice.lld.GameContext;

public class XTurnState implements GameState {

    @Override
    public void next(GameContext context) {
        System.out.println("Player with symbol O turn");
        context.setCurrentState(new OTurnState());
    }
}
