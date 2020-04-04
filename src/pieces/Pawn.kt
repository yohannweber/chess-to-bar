package pieces

import board.Position
import board.Board
import colors.Color

class Pawn(name: String, initialPosition: Position, color: Color, board: Board): Piece(name, initialPosition, color, board) {

    override fun getAllPossiblePositions(): List<Position>? {
        TODO("le simple déplacement est faux, il faut vérifier qu'un pion n'est pas présent")
            return board.allPossiblesPositions(
                mutableListOf<Position>(
                    currentPosition.relativePosition(0, color.way * 1),
                    currentPosition.relativePosition(0,color.way * 2),
                    currentPosition.relativePosition(-1,color.way * 1),
                    currentPosition.relativePosition(1,color.way * 1) ),
                color.getOpponentColor() )

    }
}