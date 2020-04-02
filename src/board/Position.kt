package board

data class Position(var abscissa: Int, var ordinate: Int) {

    fun outOfBounds(): Boolean = abscissa !in 1..8 || ordinate !in 1..8

    fun moveTo(absIncrement : Int, ordIncrement : Int) : Position {
        require( absIncrement + abscissa in 1..8 && ordIncrement + ordinate in 1..8 ) { "out of bounds"}
        return Position(abscissa + absIncrement, ordinate + ordIncrement)
    }

}

