package board

data class Position(var abscissa: Int, var ordinate: Int) {
    constructor(readablePosition : String) : this( ('a'..'h').indexOf(readablePosition[0]), readablePosition[1].toInt())

    override fun toString(): String {
        val abscissa = ('a'..'h').toList()
        return abscissa[this.abscissa - 1] + ordinate.toString()
    }

    fun outOfBounds(): Boolean = abscissa !in 1..8 || ordinate !in 1..8

    private fun relativePosition(abscissa: Int, ordinate: Int ) : Position {
        return Position(this.abscissa + abscissa, this.ordinate + ordinate)
    }
    fun nextPosition(direction: Vector) : Position{
        return relativePosition(direction.abscissa, direction.ordinate)
    }

    operator fun plus(direction: Vector): Position = Position( abscissa + direction.abscissa, ordinate + direction.ordinate)
    operator fun plus(move: Move): Position = this + move.direction
    override fun equals(others: Any?) : Boolean =
    when(others)
    {
        is Position -> abscissa == others.abscissa && ordinate == others.ordinate
        else -> false
    }


    fun nextPositions(moves : List<Move>) : List<Position>{
        val positions = mutableListOf<Position>()
        for (possibleMove in moves) {
            var position = Position(abscissa + possibleMove.direction.abscissa, ordinate + possibleMove.direction.ordinate)
            var length = 0
            while (!position.outOfBounds() && (possibleMove.direction.length == 0 || (possibleMove.direction.length != 0 && length < possibleMove.direction.length))) {
                positions.add(position)
                position = position.nextPosition(possibleMove.direction)
                length += 1
            }
        }
        return positions
    }

}


