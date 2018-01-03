package rearrangement

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Given an instance of DuplicationInserter")
internal class DuplicationInserterTest {

    private val duplicationInserter = DuplicationInserter()

    @DisplayName("When rearranging genome")
    @Nested
    inner class WhenRearranging {
        private val genome = "AACCGGTT"

        @Test
        fun `then part of the genome is duplicated and set at the end of the genome`() {
            duplicationInserter.rearrange(genome, 0, 3)
                    .apply {
                        Assertions.assertEquals("AACCGGTTAAC", this)
                    }
        }
    }
}