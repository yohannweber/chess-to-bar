package board

import colors.Black
import colors.Color
import colors.White
import pieces.*
import java.util.Collections.addAll

class Board(var pieces: List<Piece>) {

    override fun toString(): String {
        return if(pieces.count() == 0)
            "Board contains no more piece"
        else{
            var string = "Board contains ${pieces.count()} piece(s): \n"
            for (piece in pieces) {
                string += piece
                string += "\n"
            }
            string
        }
    }

    fun display(){
        println(this)
    }

    fun thereIsPiece(position : Position) : Boolean = pieces.any{ it.currentPosition == position }

    fun getPiece(position: Position) : Piece? = pieces.find{ it.currentPosition == position }
    fun getAllPositions() : List<Position> = pieces.map { it.currentPosition }
    fun allPossiblesPositions(positions: List<Position>, color: Color): List<Position> {
        var allPossiblesPositions = mutableListOf<Position>()
        allPossiblesPositions.addAll( pieces.filter{ it.currentPosition in positions.filter { it.takeable } && it.color == color.opponentColor() }.map { it.currentPosition } )
        allPossiblesPositions.addAll(positions.filter{ it !in pieces.map { it.currentPosition } })
        return allPossiblesPositions
    }
    fun getPieces(positions: List<Position>, color: Color) : List<Piece>? = pieces.filter{ it.currentPosition in positions && it.color == color }


    companion object Factory{
        fun setup() : Board{
            val white = White()
            val black = Black()
            var blackPawn = listOf<Piece>()
            var whitePawn = listOf<Piece>()
            for( i in 1..8 ) {
                blackPawn += Pawn(Position(i, 2), black)
                whitePawn += Pawn(Position(i, 7), white)
            }

            return Board( mutableListOf(
                Rook(Position(1,1), white),
                Knight(Position(2,1), white),
                Bishop(Position(3,1), white),
                King(Position(4,1), white),
                Queen(Position(5,1), white),
                Bishop(Position(6,1), white),
                Knight( Position(7,1), white),
                Rook( Position(8,1), white),

                Rook(Position(1,8), black),
                Knight(Position(2,8), black),
                Bishop(Position(3,8), black),
                King(Position(4,8), black),
                Queen(Position(5,8), black),
                Bishop(Position(6,8), black),
                Knight( Position(7,8), black),
                Rook( Position(8,8), black)

            ).apply {
                addAll(blackPawn)
                addAll(whitePawn)
            } )
        }
    }
}

