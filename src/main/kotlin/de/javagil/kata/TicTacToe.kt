package de.javagil.kata

class TicTacToe {
    private val board = "··· ··· ···"

    override fun toString() = board

    fun setX(row: Int, col: Int) = if (row == 0) "X·· ··· ···" else "··· ··X ···"
}