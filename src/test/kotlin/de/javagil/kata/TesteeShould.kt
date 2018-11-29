package de.javagil.kata

import assertk.assert
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TesteeShould {

    private val main = Testee()

    @Test
    fun `return non-empty string wrapped into single quotes`() {
        assert(main.quote("Hallo")).isEqualTo("'Hallo'")
    }

    @Test
    @Disabled
    fun `return unwapped empty string for empty string`() {
        assert(main.quote("")).isEqualTo("")
    }

}
