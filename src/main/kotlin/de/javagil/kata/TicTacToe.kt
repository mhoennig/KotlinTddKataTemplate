package de.javagil.kata

interface TicTacToe {
    companion object {
        fun newGame(): TicTacToe = TicTacToeGame()
    }

    fun move(player: Player, row: Int, col: Int): TicTacToe

    fun isWinner(player: Player): Boolean
}

enum class Player {
    X, O
}
