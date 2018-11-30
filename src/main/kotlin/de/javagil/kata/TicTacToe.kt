package de.javagil.kata

class TicTacToe {
    private val board = "··· ··· ···"

    override fun toString() = board

    fun setX(row: Int, col: Int) = "X·· ··· ···"
}