package de.javagil.kata

class TicTacToe(val board: String = "··· ··· ···") {

    override fun toString() = board

    fun setX(row: Int, col: Int) = if (row == 0) TicTacToe("X·· ··· ···") else if (col == 2) TicTacToe("··· ··X ···") else TicTacToe(board.replaceRange(4*row+col, 4*row+col+1, "X"))
}