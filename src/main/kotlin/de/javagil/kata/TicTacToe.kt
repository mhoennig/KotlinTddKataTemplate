package de.javagil.kata

class TicTacToe(val board: String = "··· ··· ···") {

    override fun toString() = board

    fun setX(row: Int, col: Int) = if (row == 0) TicTacToe("X·· ··· ···") else TicTacToe("··· ··X ···")
}