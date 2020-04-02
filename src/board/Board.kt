package board

import colors.Color
import pieces.Piece

class Board(var pieces: List<Piece>) {

    fun initialSetup( ){

    }
    fun thereIsPiece(position : Position) : Boolean = pieces.any{ it.currentPosition == position }

    fun getPiece(position: Position) : Piece? = pieces.find{ it.currentPosition == position }
    fun getAllPositions() : List<Position> = pieces.map { it.currentPosition }
    fun allPossiblesPositions(positions: List<Position>, opponentColor: Color): List<Position> = pieces.filter{ it.currentPosition in positions && it.color == opponentColor }.map { it.currentPosition }
    fun getPieces(positions: List<Position>, color: Color) : List<Piece>? = pieces.filter{ it.currentPosition in positions && it.color == color }
}