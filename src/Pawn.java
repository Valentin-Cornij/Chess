public class Pawn extends ChessPiece {

    public Pawn(String c) {
        super(c);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) return false;
        if (color.equalsIgnoreCase("white")) {
            if (((line == 1 && (toLine == 2 || toLine == 3) && column == toColumn)
                    || ((toLine - line) == 1 && column == toColumn))
                    && checkPathP(cb, line, column, toLine, toColumn)) return true;
            else if (((toLine - line) == 1 && Math.abs(column-toColumn) == 1)
                    && cb.board[toLine][toColumn] != null
                    && !cb.board[toLine][toColumn].getColor().equals(this.color)) return true;
        } else if (color.equalsIgnoreCase("black")) {
            if (((line == 6 && (toLine == 4 || toLine == 5) && column == toColumn)
                    || ((line - toLine) == 1 && column == toColumn))
                    && checkPathP(cb, line, column, toLine, toColumn)) return true;
            else if (((line - toLine) == 1 && Math.abs(column-toColumn) == 1)
                    && cb.board[toLine][toColumn] != null
                    && !cb.board[toLine][toColumn].getColor().equals(this.color)) return true;
        }
        return false;
    }

    boolean checkPathP(ChessBoard cb, int line, int column, int toLine, int toColumn) {
        if (cb.board[toLine][toColumn] != null) return false;
        return true;
    }

    public String getSymbol() {
        return "P";
    }
}
