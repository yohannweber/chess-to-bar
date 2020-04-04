import board.Board
import board.Position

fun main(){
    val chessBoard = Board.setup()
    chessBoard.display()

    print("Enter a position: ")

    val stringInput = readLine()!!
    println("You entered: $stringInput")
    val position = Position(stringInput)
    println(chessBoard.getPiece(position))

}