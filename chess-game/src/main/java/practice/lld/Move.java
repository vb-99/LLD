package practice.lld;

public class Move {
    private Cell start;
    private Cell end;
    public Move(Cell start, Cell end) {
        this.start = start;
        this.end = end;
    }
    public Cell getStart() {
        return start;
    }
    public Cell getEnd() {
        return end;
    }
    public boolean isMoveValid(){
        return start.getPiece().getChessPieceColor() != end.getPiece().getChessPieceColor();
    }
}
