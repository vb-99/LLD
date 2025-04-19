package practice.lld;

public interface PlayerFactory {
    Player createPlayer(Symbol symbol, PlayerStrategy strategy,String playerName);
}
