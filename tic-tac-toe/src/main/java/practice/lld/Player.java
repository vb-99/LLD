package practice.lld;

public class Player {
    private Symbol symbol;
    private PlayerStrategy strategy;
    private String playerName;

    public Player(Symbol symbol, PlayerStrategy strategy,String playerName) {
        this.symbol = symbol;
        this.strategy = strategy;
        this.playerName = playerName;
    }
    public String getPlayerName() {
        return playerName;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public PlayerStrategy getStrategy() {
        return strategy;
    }
}
