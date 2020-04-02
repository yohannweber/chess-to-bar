package colors

class Black : Color {
    override val way = -1

    override fun getOpponentColor(): Color = White()
}