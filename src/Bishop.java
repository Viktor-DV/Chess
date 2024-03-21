public class Bishop extends ChessPiece {

    public Bishop(String color) {
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

        if (X != Y || X == 0) {
            return false;
        }

        int stepX = (endColumn - startColumn) / X;
        int stepY = (endLine - startLine) / Y;
        int currentColumn = startColumn + stepX;
        int currentLine = startLine + stepY;

        while (currentColumn != endColumn && currentLine != endLine) {
            if (chessBoard.board[currentLine][currentColumn] != null) {
                return false;
            }
            currentColumn += stepX;
            currentLine += stepY;
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    private boolean isOnBoard(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }
}
