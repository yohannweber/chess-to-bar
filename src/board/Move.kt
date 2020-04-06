package board

data class Move(val direction : Vector, val positionType: PositionType = PositionType.MOVE_N_CAPTURE) {
}

enum class PositionType{
    MOVE_ONLY,
    CAPTURE_ONLY,
    MOVE_N_CAPTURE
}