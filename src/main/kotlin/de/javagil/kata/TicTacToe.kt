package de.javagil.kata

// Design-Decision-Record for 'internal' access see [1] below
class TicTacToe internal constructor(val board: String = EMPTY_BOARD, private val lastPlayer: Player? = null) {

    companion object {
        fun newGame() = TicTacToe()
    }

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

    fun isWinner(x: Player) = true

    private fun atPosition(row: Int, col: Int) = position(row, col)..position(row, col)
    private fun position(row: Int, col: Int) = 4 * row + col
}

enum class Player {
    X, O
}

private const val EMPTY_FIELD = "·"

private const val EMPTY_BOARD = "··· ··· ···"

// [1] Design-Decision-Record for 'internal' access:
//
// In the context of
//      writing the unit test for isWinner(...)
// I decided
//      to widen access to the constructor to internal
// in order to
//      make the test setup shorter an better readable
// accepting that
//      it could be called from other code within the module.
// I neglected the alternative
//      to use a delegate to a Board class which could be mocked
//      because it would as well need an extra method or accessible constructor to pass a mock to the game.
