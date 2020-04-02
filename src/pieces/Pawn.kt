package pieces

import board.Position
import board.Board
import colors.Black
import colors.Color

class Pawn(name: String, initialPosition: Position, color: Color, board: Board): Piece(name, initialPosition, color, board) {

    override fun getAllPossiblePositions(): List<Position>? {

        return board.allPossiblesPositions(
            mutableListOf<Position>(
            currentPosition.moveTo(0, color.way * 1),
            currentPosition.moveTo(0,color.way * 2),
            currentPosition.moveTo(-1,color.way * 1),
            currentPosition.moveTo(1,color.way * 1) ),
            color.getOpponentColor() )

    }
}