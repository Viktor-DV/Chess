public class Horse extends ChessPiece {

    public Horse(String color) {
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

        int X = Math.abs(endColumn - startColumn);
        int Y = Math.abs(endLine - startLine);

        return (X == 1 && Y == 2) || (X == 2 && Y == 1);
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    private boolean isOnBoard(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }
}
