package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece{
	
	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position initialPosition = new Position(0, 0);

		// NW
		initialPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(initialPosition) && !getBoard().thereIsAPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			initialPosition.setValues(initialPosition.getRow() - 1 , initialPosition.getColumn() - 1);
		}
		if (getBoard().positionExists(initialPosition) && isThereOpponentPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
		}

		// NE
		initialPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(initialPosition) && !getBoard().thereIsAPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			initialPosition.setValues(initialPosition.getRow() -  1, initialPosition.getColumn() + 1);
		}
		if (getBoard().positionExists(initialPosition) && isThereOpponentPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
		}

		// SW
		initialPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(initialPosition) && !getBoard().thereIsAPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			initialPosition.setValues(initialPosition.getRow() + 1, initialPosition.getColumn() - 1);
		}
		if (getBoard().positionExists(initialPosition) && isThereOpponentPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
		}

		// SE
		initialPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(initialPosition) && !getBoard().thereIsAPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			initialPosition.setValues(initialPosition.getRow() + 1, initialPosition.getColumn() + 1);
		}
		if (getBoard().positionExists(initialPosition) && isThereOpponentPiece(initialPosition)) {
			mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
		}

		return mat;
	}
}
