package pieces

import board.Position
import board.Board
import board.Vector
import colors.Color

class Rook(initialPosition: Position, color: Color): Piece("Rook", initialPosition, color) {

    override fun getAllPossiblePositions(): List<Position> {
        return mutableListOf<Position>().apply {
            addAll(currentPosition.allPositionsToDirection(Vector(1, 0)))
            addAll(currentPosition.allPositionsToDirection(Vector(0, -1)))
            addAll(currentPosition.allPositionsToDirection(Vector(-1, 0)))
            addAll(currentPosition.allPositionsToDirection(Vector(0, 1))) }
    }

}