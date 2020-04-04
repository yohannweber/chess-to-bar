package pieces

import board.Move
import board.Position
import board.Board
import colors.Black
import colors.Color

open abstract class Piece(
    val name: String,
    val initialPosition: Position,
    val color: Color
) : Move {
    var currentPosition : Position = initialPosition
    override fun toString() : String {
        return when (initialPosition.abscissa){
            in 1..3 ->
                "$color $name Queen"
            in 4..5 ->
                "$color $name"
            in 6..8 ->
                "$color $name King"
            else ->
                ""

        } + " in $currentPosition"
    }
}