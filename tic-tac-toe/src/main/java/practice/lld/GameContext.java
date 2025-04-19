package practice.lld;

import practice.lld.states.GameState;
import practice.lld.states.XTurnState;

public class GameContext {
    private GameState currentState;

    public GameContext(){
        currentState = new XTurnState();
    }
    public void setCurrentState(GameState newState) {
        currentState = newState;
    }
    public GameState getCurrentState() {
        return currentState;
    }
    public void next(){
        currentState.next(this);
    }
}
