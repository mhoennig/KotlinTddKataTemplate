package de.javagil.kata

import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import assertk.assertions.isTrue
import assertk.catch
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class TicTacToeShould {

    private val game = TicTacToe.newGame()

    @Test
    internal fun `initially start with an empty board`() {
        assertk.assert(game.toString()).isEqualTo("··· ··· ···")
    }

    @ParameterizedTest(name = "set {0} at {1}, {2} should result in {3}")
    @CsvSource(
            "X, 0, 0, X·· ··· ···",
            "X, 1, 2, ··· ··X ···",
            "X, 1, 1, ··· ·X· ···",
            "X, 2, 2, ··· ··· ··X",
            "O, 0, 0, O·· ··· ···",
            "O, 1, 2, ··· ··O ···",
            "O, 1, 1, ··· ·O· ···",
            "O, 2, 2, ··· ··· ··O"
    )
    internal fun `make move at free position`(player: Player, row: Int, col: Int, expectedBoard: String) {
        // when
        val actual = game.move(player, row, col)

        // then
        assertBoardOf(actual).isEqualTo(expectedBoard)
    }

    @ParameterizedTest(name = "given {0} and {1} making a move at position {2}, {3} should throw exception")
    @CsvSource(
            "O·· ··· ···, O, 0, 0",
            "··· ··X ···, X, 1, 2",
            "X·· ··· ···, O, 0, 0",
            "··· ··· ·O·, X, 2, 1"
    )
    internal fun `not make move at occupied position`() {
        // given
        val givenPositionIsOccupied = game.move(Player.O, 0, 0)

        // when
        val throwable = catch({ givenPositionIsOccupied.move(Player.X, 0, 0) })

        // then
        assertk.assert(throwable).isNotNull()
    }

    @Test
    internal fun `not allow repeated moves by player X`() {
        // when
        val throwable = catch({ game.move(Player.X, 0, 0).move(Player.X, 1, 0) })

        // then
        assertk.assert(throwable).isNotNull()
    }

    @Test
    internal fun `have winner X if all X in first row`() {
        // given
        val givenBoardWithTwoXInFirstRow = game.move(Player.X, 0, 0).move(Player.O, 1, 0).move(Player.X, 0, 1).move(Player.O, 1, 1)

        // when
        val actualGame = givenBoardWithTwoXInFirstRow.move(Player.X, 0, 2)

        // then
        assertk.assert(actualGame.isWinner(Player.X)).isTrue()
    }
}

private fun assertBoardOf(game: TicTacToe): BoardAssert = BoardAssert(game)

private class BoardAssert(val game: TicTacToe) {
    fun isEqualTo(expected: String) {
        assertk.assert(game.toString()).isEqualTo(expected)
    }
}

