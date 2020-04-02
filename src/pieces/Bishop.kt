package pieces

import board.Position
import board.Board
import colors.Color

class Bishop(name: String, initialPosition: Position, color: Color, board: Board): Piece(name, initialPosition, color, board) {
    override fun isPossiblePosition(position: Position): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllPossiblePositions(): List<Position> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}