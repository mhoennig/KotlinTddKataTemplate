package de.javagil.kata

class TicTacToe(val board: String = "··· ··· ···") {

    override fun toString() = board

    fun move(x: Player, row: Int, col: Int) = TicTacToe(board.replaceRange(atPosition(row, col), x.name))

    private fun atPosition(row: Int, col: Int) = position(row, col)..position(row, col)
    private fun position(row: Int, col: Int) = 4 * row + col
}


enum class Player {
    X, O
}