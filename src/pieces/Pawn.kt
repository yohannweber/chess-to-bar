package pieces

import board.Position
import board.Board
import colors.Black
import colors.Color

class Pawn(name: String, initialPosition: Position, color: Color, board: Board): Piece(name, initialPosition, color, board) {
    var way : Int = 1

    init {
        when(color) {
            is Black -> way = -1
        }
    }

    override fun getAllPossiblePositions(): List<Position>? {
        var possiblePositions = mutableListOf<Position>()

        try { possiblePositions.add(currentPosition.moveTo(0, way * 1)) } catch(e: IllegalArgumentException){}

        if( initialPosition === currentPosition )
            try{ possiblePositions.add(currentPosition.moveTo(0,way * 2)) } catch(e: IllegalArgumentException){}
        try{ var leftCapturePosition = currentPosition.moveTo(-1,1)
        if (board.hasPieceInThisPosition(leftCapturePosition))
            possiblePositions.add(leftCapturePosition) } catch(e: IllegalArgumentException){}
        try{ var rightCapturePosition = currentPosition.moveTo(1,1)
        if (board.hasPieceInThisPosition(rightCapturePosition))
            possiblePositions.add(rightCapturePosition) } catch(e: IllegalArgumentException){}
        return possiblePositions
    }
}