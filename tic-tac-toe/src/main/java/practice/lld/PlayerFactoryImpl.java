package practice.lld;

public class PlayerFactoryImpl implements PlayerFactory {

    @Override
    public Player createPlayer(Symbol symbol, PlayerStrategy strategy, String playerName) {
        return new Player(symbol,strategy,playerName);
    }
}
