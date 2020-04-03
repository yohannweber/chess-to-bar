package pieces

import board.Position
import board.Board
import colors.Color

class King(name: String, initialPosition: Position, color: Color, board: Board): Piece(name, initialPosition, color, board) {

    override fun getAllPossiblePositions(): List<Position> {
        return board.allPossiblesPositions(
            mutableListOf<Position>(
                currentPosition.moveTo(0,  1),   //front step
                currentPosition.moveTo(-1, 1),  //back step
                currentPosition.moveTo(-1, 0), //left step
                currentPosition.moveTo(1, 0) , //right step
                currentPosition.moveTo(1, 1) , //diagonal up right step
                currentPosition.moveTo(-1, 0) , //diagonal up left step
                currentPosition.moveTo(1, -1) , //diagonal down right step
                currentPosition.moveTo(-1, -1)), //diagonal down left step
            color.getOpponentColor() )
    }
}