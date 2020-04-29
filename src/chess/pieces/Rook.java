package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position initialPosition = new Position(0, 0);

		// above
		initialPosition.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(initialPosition) && !getBoard().thereIsAPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			initialPosition.setRow(initialPosition.getRow() - 1);
		}
		if (getBoard().positionExists(initialPosition) && isThereOpponentPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
		}

		// left
		initialPosition.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(initialPosition) && !getBoard().thereIsAPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			initialPosition.setColumn(initialPosition.getColumn() - 1);
		}
		if (getBoard().positionExists(initialPosition) && isThereOpponentPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
		}

		// right
		initialPosition.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(initialPosition) && !getBoard().thereIsAPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			initialPosition.setColumn(initialPosition.getColumn() + 1);
		}
		if (getBoard().positionExists(initialPosition) && isThereOpponentPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
		}

		// below
		initialPosition.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(initialPosition) && !getBoard().thereIsAPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			initialPosition.setRow(initialPosition.getRow() + 1);
		}
		if (getBoard().positionExists(initialPosition) && isThereOpponentPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
		}

		return mat;
	}
}
