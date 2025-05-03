package practice.lld;

import practice.lld.pieces.ChessPiece;

public class Cell {
    private final int row;
    private final int col;
    private ChessPiece piece;

    public Cell(int row, int col, ChessPiece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    public ChessPiece getPiece() {
        return piece;
    }
    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }
}
