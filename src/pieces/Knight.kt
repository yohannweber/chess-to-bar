package pieces

import board.Position
import board.Board
import colors.Color

class Knight(name: String, initialPosition: Position, color: Color, board: Board): Piece(name, initialPosition, color, board) {

    override fun getAllPossiblePositions(): List<Position> {
        return board.allPossiblesPositions(
            mutableListOf<Position>(
                currentPosition.relativePosition(1,  2),  //1 hour
                currentPosition.relativePosition(2, 1),  //2 hour
                currentPosition.relativePosition(2, -1), //4 hour
                currentPosition.relativePosition(1, -2) , //5 hour
                currentPosition.relativePosition(-1, -2) , //7 hour
                currentPosition.relativePosition(-2, -1) , //8 hour
                currentPosition.relativePosition(-2, 1) , //10 hour
                currentPosition.relativePosition(-1, 2) ), //11 hour
            color.getOpponentColor() )
    }
}