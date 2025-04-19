package practice.lld.states;

import practice.lld.GameContext;

public interface GameState {
    void next(GameContext context);
}
