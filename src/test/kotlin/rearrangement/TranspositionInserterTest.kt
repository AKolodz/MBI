package rearrangement

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class TranspositionInserterTest {

    private val transpositionInserter = TranspositionInserter()

    @DisplayName("When rearranging genome")
    @Nested
    inner class WhenRearranging {
        private val genome = "AACCGGTT"

        @Test
        fun `then part of the genome is moved to different random position`() {
            transpositionInserter.rearrange(genome, 2, 3)
                    .apply {
                        Assertions.assertNotEquals("AACCGGTT", this)
                        Assertions.assertEquals(genome.length, this.length)
                    }
        }
    }
}