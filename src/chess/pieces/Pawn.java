package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position initialPosition = new Position(0, 0);
		
		if(getColor() == Color.WHITE) {
			initialPosition.setValues(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(initialPosition) && !getBoard().thereIsAPiece(initialPosition)) {
				mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			}
			
			initialPosition.setValues(position.getRow() - 2, position.getColumn());
			Position p = new Position(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(initialPosition) && !getBoard().thereIsAPiece(initialPosition) && getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0) {
				mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			}
			
			initialPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
			if(getBoard().positionExists(initialPosition) && isThereOpponentPiece(initialPosition)) {
				mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			}
			
			initialPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
			if(getBoard().positionExists(initialPosition) && isThereOpponentPiece(initialPosition)) {
				mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			}
		}else {
			initialPosition.setValues(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(initialPosition) && !getBoard().thereIsAPiece(initialPosition)) {
				mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			}
			
			initialPosition.setValues(position.getRow() + 2, position.getColumn());
			Position p = new Position(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(initialPosition) && !getBoard().thereIsAPiece(initialPosition) && getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0) {
				mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			}
			
			initialPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
			if(getBoard().positionExists(initialPosition) && isThereOpponentPiece(initialPosition)) {
				mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			}
			
			initialPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
			if(getBoard().positionExists(initialPosition) && isThereOpponentPiece(initialPosition)) {
				mat[initialPosition.getRow()][initialPosition.getColumn()] = true;
			}
		}
		
		return mat;
	}
	
	public String toString() {
		return "P";
	}

}
