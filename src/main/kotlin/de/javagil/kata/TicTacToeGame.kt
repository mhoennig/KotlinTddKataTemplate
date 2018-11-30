package de.javagil.kata

internal class TicTacToeGame(val board: String = EMPTY_BOARD, private val lastPlayer: Player? = null): TicTacToe {

    companion object {
        fun newGame() = TicTacToeGame()
    }

    private val transposedBoard: String get() =
        "${board[0]}${board[4]}${board[8]} ${board[1]}${board[5]}${board[9]} ${board[2]}${board[6]}${board[10]}"

    private val diagonals: String get() =
        "${board[0]}${board[5]}${board[10]} ${board[2]}${board[5]}${board[8]}"

    override fun toString() = board

    override fun move(player: Player, row: Int, col: Int): TicTacToe {
        if (player == lastPlayer) {
            throw IllegalAccessError()
        }
        if (board.substring(atPosition(row, col)) != EMPTY_FIELD) {
            throw IllegalStateException()
        }
        return TicTacToeGame(board.replaceRange(atPosition(row, col), player.name), player)
    }

    override fun isWinner(player: Player) = board.contains(player.name.repeat(3))
            || transposedBoard.contains(player.name.repeat(3))
            || diagonals.contains(player.name.repeat(3))

    private fun atPosition(row: Int, col: Int) = position(row, col)..position(row, col)
    private fun position(row: Int, col: Int) = 4 * row + col
}

private const val EMPTY_FIELD = "·"

private const val EMPTY_BOARD = "··· ··· ···"
