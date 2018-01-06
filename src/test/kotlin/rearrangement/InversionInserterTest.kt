package rearrangement

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Given an instance of InversionInserter")
internal class InversionInserterTest {

    private val inversionInserter = InversionInserter()

    @DisplayName("When rearranging genome")
    @Nested
    inner class WhenRearranging {
        private val genome = "AACCGGTT"

        @Test
        fun `then part of genome is reversed`() {
            inversionInserter.rearrange(genome, 0,3)
                    .apply {
                        Assertions.assertEquals("CAACGGTT", this)
                    }
        }
    }
}