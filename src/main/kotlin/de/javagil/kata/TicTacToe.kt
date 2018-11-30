package de.javagil.kata

class TicTacToe(val board: String = "··· ··· ···") {

    override fun toString() = board

    fun setX(row: Int, col: Int) = TicTacToe(board.replaceRange(position(row, col), position(row, col) +1, "X"))

    private fun position(row: Int, col: Int) = 4 * row + col
}