public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn) {
        if (!isOnBoard(startLine, startColumn) || !isOnBoard(endLine, endColumn)) {
            return false;
        }

        ChessPiece targetPiece = chessBoard.board[endLine][endColumn];

        if (targetPiece != null && !targetPiece.getColor().equals(color)) {
            return true;
        }

        if (startLine != endLine && startColumn != endColumn) {
            return false;
        }

        if (startLine == endLine && startColumn == endColumn) {
            return false;
        }

        if (startLine == endLine) {
            int start = Math.min(startColumn, endColumn) + 1;
            int end = Math.max(startColumn, endColumn);
            for (int i = start; i < end; i++) {
                if (chessBoard.board[startLine][i] != null) {
                    return false;
                }
            }
        } else {
            int start = Math.min(startLine, endLine) + 1;
            int end = Math.max(startLine, endLine);
            for (int i = start; i < end; i++) {
                if (chessBoard.board[i][startColumn] != null) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    private boolean isOnBoard(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }
}
