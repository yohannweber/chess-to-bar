package colors

class White : Color {
    override val way = 1
    override val name = "White"
    override fun getOpponentColor(): Color = Black()
    override fun toString() : String = name
}