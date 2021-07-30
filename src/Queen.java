public class Queen extends ChessPiece {

    public Queen(String c) {
        super(c);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) return false;
        if (((toLine==line && Math.abs(toColumn-column) > 0) || (toColumn==column && Math.abs(toLine-line) > 0))
                && checkPathR(cb, line, column, toLine, toColumn)) return true;
        if ((Math.abs(toLine - line) == Math.abs(toColumn - column))
                && line != toLine
                && checkPathB(cb, line, column, toLine, toColumn)) return true;;
        return false;
    }

    boolean checkPathB(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        int y1 = toLine - line > 0 ? 1 : -1;
        int y2 = 1;
        int y3 = y2 * y1;
        int x1 = toColumn - column > 0 ? 1 : -1;
        int x2 = 1;
        int x3 = x2 * x1;

        for (int i = 1; i < Math.abs(toLine-line); i++) {
            if (cb.board[line+y3][column+x3] != null) return false;
            y3 = ++y2 * y1;
            x3 = ++x2 * x1;
        }
        if (cb.board[toLine][toColumn] != null && cb.board[toLine][toColumn].getColor().equals(this.color)) return false;
        return true;
    }

    boolean checkPathR(ChessBoard cb, int line, int column, int toLine, int toColumn) {

        boolean oxoy = toColumn - column == 0 ? true : false;
        int y1 = toLine - line > 0 ? 1 : -1;
        int y2 = !oxoy ? 0 : 1;
        int y3 = y2 * y1;
        int x1 = toColumn - column > 0 ? 1 : -1;
        int x2 = oxoy ? 0 : 1;
        int x3 = x2 * x1;
        int iter = Math.max(Math.abs(toLine-line), Math.abs(toColumn - column));

        for (int i = 1; i < iter; i++) {
            if (cb.board[line+y3][column+x3] != null) return false;
            y3 = !oxoy ? y2 * y1 : ++y2 * y1;
            x3 = oxoy ? x2 * x1 : ++x2 * x1;
        }
        if (cb.board[toLine][toColumn] != null && cb.board[toLine][toColumn].getColor().equals(this.color)) return false;
        return true;
    }

    public String getSymbol() {
        return "Q";
    }
}
