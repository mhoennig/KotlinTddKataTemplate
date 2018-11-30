package de.javagil.kata

import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class TicTacToeShould {

    private val game = TicTacToe()

    @Test
    internal fun `create a tic tac toe game`() {
        game
    }

    @Test
    internal fun `initially start with an empty board`() {
        assertk.assert(game.toString()).isEqualTo("··· ··· ···")
    }

    @Test
    internal fun `set X at free position`() {
        assertk.assert(game.setX(0,0).toString()).isEqualTo("X·· ··· ···")
    }
}

