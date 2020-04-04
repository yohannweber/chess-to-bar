package pieces

import board.Position
import board.Board
import board.Vector
import colors.Color

class Bishop(initialPosition: Position, color: Color): Piece("Bishop", initialPosition, color) {

    override fun getAllPossiblePositions(): List<Position> {
        return mutableListOf<Position>().apply {
            addAll(currentPosition.allPositionsToDirection(Vector(1, 1)))
            addAll(currentPosition.allPositionsToDirection(Vector(1, -1)))
            addAll(currentPosition.allPositionsToDirection(Vector(-1, -1)))
            addAll(currentPosition.allPositionsToDirection(Vector(-1, 1)))
        }
    }

}