package colors

class Black : Color {
    override val way = -1
    override val name = "Black"
    override fun opponentColor(): Color = White()
    override fun toString() : String = name
}