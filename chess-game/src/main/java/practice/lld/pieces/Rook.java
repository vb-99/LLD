package practice.lld.pieces;

import practice.lld.pieces.strategies.RookMovementStrategy;

public class Rook extends ChessPiece{
    public Rook(ChessPieceColor chessPieceColor) {
        super(chessPieceColor, new RookMovementStrategy());
    }
}
