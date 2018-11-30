package de.javagil.kata

import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class TicTacToeShould {

    @Test
    internal fun `create a tic tac toe game`() {
        TicTacToe()
    }

    @Test
    internal fun `initially start with an empty board`() {
        assertk.assert(TicTacToe().toString()).isEqualTo("··· ··· ···")
    }

    @Test
    internal fun `set X at free position`() {
        assertk.assert(TicTacToe().setX(0,0).toString()).isEqualTo("X·· ··· ···")
    }
}

