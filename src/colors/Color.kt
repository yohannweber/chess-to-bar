package colors

interface Color {
    val way : Int
    val name : String
    fun opponentColor() : Color

}