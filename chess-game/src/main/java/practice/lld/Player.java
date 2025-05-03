package practice.lld;

import practice.lld.pieces.ChessPieceColor;

public class Player {
    private final String name;
    private final ChessPieceColor chessPieceColor;
    private PlayerStrategy playerStrategy;

    public Player(String name, ChessPieceColor chessPieceColor,PlayerStrategy playerStrategy) {
        this.name = name;
        this.chessPieceColor = chessPieceColor;
        this.playerStrategy = playerStrategy;
    }
    public String getName() {
        return name;
    }
    public ChessPieceColor getChessPieceColor() {
        return chessPieceColor;
    }
    public PlayerStrategy getPlayerStrategy() {
        return playerStrategy;
    }
}
