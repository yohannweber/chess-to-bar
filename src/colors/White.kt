package colors

class White : Color {
    override val way = 1
    override fun getOpponentColor(): Color = Black()
}