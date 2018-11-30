package de.javagil.kata

import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class TicTacToeShould {

    private val game = TicTacToe()

    @Test
    internal fun `initially start with an empty board`() {
        assertk.assert(game.toString()).isEqualTo("··· ··· ···")
    }

    @Test
    internal fun `set X at free position`() {
        // when
        val actual = game.setX(0, 0)

        // then
        assertBoardOf(actual).isEqualTo("X·· ··· ···")
    }

    @Test
    internal fun `set X at free position 1, 2`() {
        // when
        val actual = game.setX(1, 2)

        // then
        assertBoardOf(actual).isEqualTo("··· ··X ···")
    }
}

private fun assertBoardOf(game: String): BoardAssert = BoardAssert(game)

private class BoardAssert(val game: String) {
    fun isEqualTo(expected: String) {
        assertk.assert(game).isEqualTo(expected)
    }
}

