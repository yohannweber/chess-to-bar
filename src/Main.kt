import board.Board
import board.Position
import java.lang.IllegalArgumentException
import java.util.*

fun main() {
    val chessBoard = Board.setup()
    println(chessBoard)

    var exit = false

    do {

        // Creates an instance which takes input from standard input (keyboard)
        val reader = Scanner(System.`in`)

        print(
            "What do you want to do ? \n" +
                    "1. Play a piece \n" +
                    "2. Display board \n" +
                    "3. Show previous moves \n"
        )
        when (reader.next().toUpperCase()) {
            "1" -> {
                playMove(chessBoard)
            }
            "2" -> println(chessBoard)
            "3" -> println(chessBoard.history)
            else -> "Unknown command"
        }

        print("Continue ? O/N")
        exit = when (reader.next().toUpperCase()) {
            "O" -> false
            else -> true
        }
    } while (!exit)

}

fun getPosition(): Position {
    // Creates an instance which takes input from standard input (keyboard)
    val reader = Scanner(System.`in`)
    print("Enter a abscissa: ")
    var abscissa: Int = reader.nextInt()
    print("Enter a  ordinate ")
    var ordinate: Int = reader.nextInt()

    return Position(abscissa, ordinate)

}

fun playMove(chessBoard: Board) {
    val reader = Scanner(System.`in`)
    var piece = chessBoard.getPiece(getPosition())
    if (piece != null) println(
        piece.toString() + "\nall possibles moves are " + chessBoard.allNextPossiblePositions(
            piece
        )
    )
    else
        println("no piece found")

    if (piece != null) {
        print(
            "1. Move the piece \n" +
                    "Others Skip \n"
        )
        when (reader.next().toUpperCase()) {
            "1" -> {
                try {
                    chessBoard.moveTo(piece, getPosition())
                } catch (e: IllegalArgumentException) {
                    print(e.message + "\n")
                }
            }

            else -> "Skip command"
        }
    }
}