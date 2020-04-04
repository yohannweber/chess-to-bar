package pieces

import board.Position
import board.Board
import colors.Color

class Pawn(initialPosition: Position, color: Color): Piece("Pawn", initialPosition, color) {
    override fun toString(): String = "$color $name in $currentPosition"

    override fun getAllPossiblePositions(): List<Position>? {
        TODO("le simple déplacement est faux, il faut vérifier qu'un pion n'est pas présent")
            return mutableListOf<Position>(
                    currentPosition.relativePosition(0, color.way * 1, false), // only move, not takeable
                    currentPosition.relativePosition(0,color.way * 2, false), // only move, not takeable
                    currentPosition.relativePosition(-1,color.way * 1),
                    currentPosition.relativePosition(1,color.way * 1) )

    }
}