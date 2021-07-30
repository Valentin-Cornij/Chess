public class King extends ChessPiece {

    public King(String c) {
        super(c);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) return false;
        if (checkPathH(cb, line, column, toLine, toColumn)) {
            if (((toLine == line && Math.abs(toColumn - column) > 0) && (toLine == line && Math.abs(toColumn - column) < 2))
                    || ((toColumn == column && Math.abs(toLine - line) > 0) && (toColumn == column && Math.abs(toLine - line) < 2)))
                return true;
            if ((Math.abs(toLine - line) == Math.abs(toColumn - column)) && line != toLine && Math.abs(toLine - line) < 2)
                return true;
        }
        return false;
    }

    boolean checkPathH(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (cb.board[toLine][toColumn] != null && cb.board[toLine][toColumn].getColor().equals(this.color)) return false;
        return true;
    }

    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard cb, int line, int column) {
        boolean result = false;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (cb.board[y][x] != null && !cb.board[y][x].getColor().equals(color)) {
                    if (cb.board[y][x].canMoveToPosition(cb, y, x, line, column)) result = true;
                }
            }
        }
        return result;
    }
}
