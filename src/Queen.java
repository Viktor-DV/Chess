public class Queen extends ChessPiece {

    public Queen(String color) {
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

        if (X == 0 && Y == 0) {
            return false;
        }

        if (X == 0 || Y == 0) {
            if (X == 0) {

