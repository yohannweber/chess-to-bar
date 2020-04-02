package board

import pieces.Piece

class Board(var pieces: MutableList<Piece>) {

    fun initialSetup( ){

    }
    fun hasPieceInThisPosition(position : Position) : Boolean{
       return pieces.any{ it.currentPosition == position }
    }
}