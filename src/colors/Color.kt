package colors

interface Color {
    val way : Int
    fun getOpponentColor() : Color
}