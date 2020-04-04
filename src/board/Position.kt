package board

data class Position(var abscissa: Int, var ordinate: Int, val takeable : Boolean = true) {
    constructor(readablePosition : String) : this( ('a'..'h').indexOf(readablePosition[0]), readablePosition[1].toInt())

    override fun toString(): String {
        val abscissa = ('a'..'h').toList()
        return abscissa[this.abscissa - 1] + ordinate.toString()
    }

    fun outOfBounds(): Boolean = abscissa !in 1..8 || ordinate !in 1..8

    fun relativePosition(abscissa: Int, ordinate: Int, takeable: Boolean = true ) : Position {
        //require( absIncrement + abscissa in 1..8 && ordIncrement + ordinate in 1..8 ) { "out of bounds"}
        return Position(this.abscissa + abscissa, this.ordinate + ordinate, takeable)
    }
    fun nextPosition(direction: Vector) : Position{
        return relativePosition(direction.abscissa, direction.ordinate)
    }

    fun allPositionsToDirection(direction : Vector) : List<Position>{
        val positions = mutableListOf<Position>()
        var position = Position(abscissa + direction.abscissa, ordinate + direction.ordinate)
        while (!position.outOfBounds()){
            positions.add(position)
            position = position.nextPosition(direction)
        }
        return positions
    }

}

