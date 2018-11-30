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
}

