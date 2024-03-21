public class Pawn extends ChessPiece {

    public Pawn(String color) {
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

        int X = endColumn - startColumn;
        int Y = endLine - startLine;

        if (color.equals("White")) {
            if (startLine == 1 && X == 0 && (Y == 1 || Y == 2) && chessBoard.board[endLine][endColumn] == null) {
                return true;
            }
            return X == 0 && Y == 1 && chessBoard.board[endLine][endColumn] == null;
        } else {
            if (startLine == 6 && X == 0 && (Y == -1 || Y == -2) && chessBoard.board[endLine][endColumn] == null) {
                return true;
            }
            return X == 0 && Y == -1 && chessBoard.board[endLine][endColumn] == null;
        }
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    private boolean isOnBoard(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }
}
