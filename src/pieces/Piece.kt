package pieces

import board.Move
import board.Position
import board.Board
import colors.Color

open abstract class Piece(
    val name: String,
    val initialPosition: Position,
    val color: Color,
    val board: Board
) : Move {
    var currentPosition : Position = initialPosition
}