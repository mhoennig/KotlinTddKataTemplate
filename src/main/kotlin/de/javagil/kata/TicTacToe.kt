package de.javagil.kata

class TicTacToe(val board: String = EMPTY_BOARD, private val lastPlayer: Player? = null) {

    override fun toString() = board

    fun move(player: Player, row: Int, col: Int): TicTacToe {
        if (player == lastPlayer) {
            throw IllegalAccessError()
        }
        if (board.substring(atPosition(row, col)) != EMPTY_FIELD) {
            throw IllegalStateException()
        }
        return TicTacToe(board.replaceRange(atPosition(row, col), player.name), player)
    }

    private fun atPosition(row: Int, col: Int) = position(row, col)..position(row, col)

    private fun position(row: Int, col: Int) = 4 * row + col
}

enum class Player {
    X, O
}

private const val EMPTY_FIELD = "·"

private const val EMPTY_BOARD = "··· ··· ···"