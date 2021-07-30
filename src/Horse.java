public class Horse extends ChessPiece {

    public Horse(String c) {
        super(c);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) return false;
        if (((Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 1)
                || (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 2))
                && checkPathH(cb, line, column, toLine, toColumn)) return true;
        else return false;
    }

    boolean checkPathH(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (cb.board[toLine][toColumn] != null && cb.board[toLine][toColumn].getColor().equals(this.color)) return false;
        return true;
    }

    public String getSymbol() {
        return "H";
    }
}
