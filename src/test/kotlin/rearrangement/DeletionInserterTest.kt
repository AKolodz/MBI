package rearrangement

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Given an instance of DeletionInserter")
internal class DeletionInserterTest {

    private val deletionInserter = DeletionInserter()

    @Nested
    @DisplayName("When rearranging genome")
    inner class WhenRearranging {
        private val genome = "AACCGGTT"
        @Test
        fun `then part of genome is removed`() {
            deletionInserter.rearrange(genome, 0, 3)
                    .apply {
                        Assertions.assertEquals("CGGTT", this)
                    }
        }
    }
}