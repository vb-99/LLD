package practice.lld.pieces;

public class PieceFactory {
    public static ChessPiece createChessPiece(String piece,ChessPieceColor color){
        return switch (piece) {
            case "king" -> new King(color);
            case "queen" -> new Queen(color);
            case "knight" -> new Knight(color);
            case "bishop" -> new Bishop(color);
            case "rook" -> new Rook(color);
            case "pawn" -> new Pawn(color);
            default -> throw new IllegalArgumentException("Invalid piece: " + piece);
        };
    }
}
