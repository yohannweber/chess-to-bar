package pieces

import board.Position
import board.Board
import board.Move
import board.Vector
import colors.Color

class King(initialPosition: Position, color: Color)
    : Piece("King", initialPosition, color,
    mutableListOf<Move>(
        Move(Vector(0,1,1)),
        Move(Vector(-1,1,1)),
        Move(Vector(-1,0,1)),
        Move(Vector(1,0,1)),
        Move(Vector(1,1,1)),
        Move(Vector(-1,0,1)),
        Move(Vector(1,-1,1)),
        Move(Vector(-1,-1,1))
    )
) {
}