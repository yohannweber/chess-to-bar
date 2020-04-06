package pieces

import board.Move
import board.Position
import board.PositionType
import board.Vector
import colors.Color

class Pawn(initialPosition: Position, color: Color)
    : Piece("Pawn", initialPosition, color,
    mutableListOf<Move>(
        Move(Vector(0,color.way * 2, 1), PositionType.MOVE_ONLY ),
        Move(Vector(0, color.way * 1, 1), PositionType.MOVE_ONLY ),
        Move(Vector(-1,color.way * 1,1), PositionType.CAPTURE_ONLY),
        Move(Vector(1,color.way * 1,1), PositionType.CAPTURE_ONLY))
)
{
    override fun toString(): String = "$color $name in $currentPosition"

    override fun moveTo(position: Position){
        super.moveTo(position)
        if (count == 1)
            possibleMoves.removeAt(0)
    }

}