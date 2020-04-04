package pieces

import board.Position
import board.Board
import board.Vector
import colors.Color

class Bishop(name: String, initialPosition: Position, color: Color, board: Board): Piece(name, initialPosition, color, board) {

    override fun getAllPossiblePositions(): List<Position> {
        val possiblesPositions = mutableListOf<Position>()
        possiblesPositions.apply {
            addAll(currentPosition.allPositionsToDirection(Vector(1, 1)))
            addAll(currentPosition.allPositionsToDirection(Vector(1, -1)))
            addAll(currentPosition.allPositionsToDirection(Vector(-1, -1)))
            addAll(currentPosition.allPositionsToDirection(Vector(-1, 1)))
        }
        return board.allPossiblesPositions( possiblesPositions, color.getOpponentColor() )
    }

}