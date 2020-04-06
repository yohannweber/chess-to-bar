import board.Board
import board.Position
import java.util.*

fun main(){
    val chessBoard = Board.setup()
    chessBoard.display()

    var exit = false

    do {

        // Creates an instance which takes input from standard input (keyboard)
        val reader = Scanner(System.`in`)
        var piece = chessBoard.getPiece(getPosition())
        println(piece)

        print("What do you want to do ? \n" +
                "1. Get possible moves \n" +
                "2. Move the piece \n" +
                "3. nothing \n")
        if(piece != null)
            when(reader.next().toUpperCase()){
                "1" -> if(piece != null) println(chessBoard.allNextPossiblePositions(piece))
                else
                    println("no piece found")
                "2" -> {
                    try {
                        chessBoard.moveTo(piece, getPosition())
                    }
                    catch ( e : IllegalArgumentException){
                        println("Position not possible")
                    }
                }
                "3" -> "todo"
                else -> "Unknown command"
            }
        else
            println("Piece does not exist")

        print("Continue ? O/N")
        exit = when(reader.next().toUpperCase()){
            "O" -> false
            else ->true
        }
    }
    while (!exit)

}

fun getPosition() : Position{
    // Creates an instance which takes input from standard input (keyboard)
    val reader = Scanner(System.`in`)
    print("Enter a abscissa: ")
    var abscissa: Int = reader.nextInt()
    print("Enter a  ordinate ")
    var ordinate: Int = reader.nextInt()

    return Position(abscissa, ordinate)

}