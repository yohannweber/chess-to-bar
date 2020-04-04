package pieces

import board.Position
import colors.Color

class Knight(initialPosition: Position, color: Color): Piece("Knight", initialPosition, color) {

    override fun getAllPossiblePositions(): List<Position> {
        return mutableListOf<Position>(
                currentPosition.relativePosition(1,  2),  //1 hour
                currentPosition.relativePosition(2, 1),  //2 hour
                currentPosition.relativePosition(2, -1), //4 hour
                currentPosition.relativePosition(1, -2) , //5 hour
                currentPosition.relativePosition(-1, -2) , //7 hour
                currentPosition.relativePosition(-2, -1) , //8 hour
                currentPosition.relativePosition(-2, 1) , //10 hour
                currentPosition.relativePosition(-1, 2) ) //11 hour

    }
}