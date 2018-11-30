package de.javagil.kata

import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class TicTacToeShould {

    private val game = TicTacToe()

    @Test
    internal fun `initially start with an empty board`() {
        assertk.assert(game.toString()).isEqualTo("··· ··· ···")
    }

    @ParameterizedTest
    @CsvSource(
            "0, 0, X·· ··· ···",
            "1, 2, ··· ··X ···",
            "1, 1, ··· ·X· ···"
    )
    internal fun `set X at free position`(row: Int, col: Int, expectedBoard: String) {
        // when
        val actual = game.setX(row, col)

        // then
        assertBoardOf(actual).isEqualTo(expectedBoard)
    }
}

private fun assertBoardOf(game: TicTacToe): BoardAssert = BoardAssert(game)

private class BoardAssert(val game: TicTacToe) {
    fun isEqualTo(expected: String) {
        assertk.assert(game.toString()).isEqualTo(expected)
    }
}

