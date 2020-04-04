package colors

class White : Color {
    override val way = 1
    override val name = "White"
    override fun opponentColor(): Color = Black()
    override fun toString() : String = name
}