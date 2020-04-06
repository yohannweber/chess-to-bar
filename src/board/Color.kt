package board

enum class Color(
    val way : Int,
    private val colorName : String )
{
    BLACK(-1, "Black"),
    WHITE(1, "White");
    override fun toString() : String = colorName
}
