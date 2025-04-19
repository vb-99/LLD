package practice.lld.states;

import practice.lld.GameContext;

public class OWonState implements GameState{
    @Override
    public void next(GameContext context) {
        System.out.println("O Won");
        context.setCurrentState(new GameOverState());
    }

}
