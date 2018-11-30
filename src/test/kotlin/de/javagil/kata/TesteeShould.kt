package de.javagil.kata

import assertk.assert
import assertk.assertions.isEqualTo
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TesteeShould {

    private val testee = Testee()

    @Test
    fun `return non-empty string wrapped into single quotes`() {
        assert(testee.quote("Hallo")).isEqualTo("'Hallo'")
    }

    @Test
    @Disabled
    fun `return unwapped empty string for empty string`() {
        assert(testee.quote("")).isEqualTo("")
    }

    @Test
    internal fun `call the mock`() {
        // given
        val givenOutput = "Output"
        val givenInput = "Input"
        val delegateMock = mockk<Delegate>()
        val testee = Testee(delegateMock)
        every { delegateMock.inner(any()) } returns givenOutput

        // when
        val actual = testee.quote(givenInput)

        // then
        verify { delegateMock.inner(givenInput) }
        assert(actual).isEqualTo(givenOutput)

    }
}
