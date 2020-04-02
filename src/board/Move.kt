package board

interface Move {
    fun isPossiblePosition(position: Position): Boolean {
        return getAllPossiblePositions()?.any{ it == position } ?: false
    }
    fun getAllPossiblePositions() : List<Position>?
}