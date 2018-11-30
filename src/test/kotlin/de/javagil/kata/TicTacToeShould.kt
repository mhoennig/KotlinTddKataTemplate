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

    @ParameterizedTest(name = "set {0} at {1}, {2} should result in {3}")
    @CsvSource(
            "X, 0, 0, X·· ··· ···",
            "X, 1, 2, ··· ··X ···",
            "X, 1, 1, ··· ·X· ···",
            "X, 2, 2, ··· ··· ··X"
    )
    internal fun `make move at free position`(player: Player, row: Int, col: Int, expectedBoard: String) {
        // when
        val actual = game.move(player, row, col)

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

