package board

import pieces.*
import java.lang.IllegalArgumentException

class Board(private var pieces: MutableList<Piece>) {
    val history = mutableListOf<Pair<Position, Position>>()

    init {
        sort()
    }

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

    fun moveTo(piece: Piece, position: Position){
        //require(position in allNextPossiblePositions(piece)){ "Position not possible"}
        val allPossiblePosition = allNextPossiblePositions(piece)
        if (position !in allPossiblePosition) throw  IllegalArgumentException("Position is not possible")
        pieces.removeIf { it.currentPosition == position }
        history.add(Pair(piece.currentPosition, position))
        piece.moveTo(position)
        sort()

    }

    private fun sort(){
        pieces.sortBy { it.currentPosition }
    }

    fun thereIsPiece(position : Position) : Boolean = pieces.any{ it.currentPosition == position }
    fun getPiece(position: Position) : Piece? = pieces.find{ it.currentPosition == position }
    fun allCurrentPositions() : List<Position> = pieces.map { it.currentPosition }
    fun allNextPossiblePositions(piece: Piece): List<Position> {
        val positions = mutableListOf<Position>()
        for (possibleMove in piece.possibleMoves) {
            var position = piece.currentPosition + possibleMove
            var length = 0
            while (!position.outOfBounds() && (possibleMove.direction.length == 0 || (possibleMove.direction.length != 0 && length < possibleMove.direction.length))) {
                if ( pieces.any{ it.currentPosition == position && it.color != piece.color }){
                    if(possibleMove.positionType in listOf<PositionType>( PositionType.CAPTURE_ONLY, PositionType.MOVE_N_CAPTURE))
                        positions.add(position)
                    break
                }
                else{
                    if ( pieces.any{ it.currentPosition == position && it.color == piece.color })
                        break
                    else{
                        //if (position !in pieces.map { it.currentPosition } && possibleMove.positionType in listOf<PositionType>( PositionType.MOVE_ONLY, PositionType.MOVE_N_CAPTURE) ){
                        if (possibleMove.positionType in listOf<PositionType>( PositionType.MOVE_ONLY, PositionType.MOVE_N_CAPTURE) ){
                            positions.add(position)
                            position += possibleMove
                        }
                        length += 1
                    }
                }
            }
        }
        return positions
    }
    fun getPieces(positions: List<Position>, color: Color) : List<Piece>? = pieces.filter{ it.currentPosition in positions && it.color == color }


    companion object Factory{
        fun setup() : Board{
            val white = Color.WHITE
            val black = Color.BLACK
            var blackPawn = listOf<Piece>()
            var whitePawn = listOf<Piece>()
            for( i in 1..8 ) {
                blackPawn += Pawn(Position(i, 7), black)
                whitePawn += Pawn(Position(i, 2), white)
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

