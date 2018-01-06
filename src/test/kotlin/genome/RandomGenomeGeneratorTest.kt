package genome

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Given instance of RandomGenomeGenerator")
internal class RandomGenomeGeneratorTest {

    private var generator = RandomGenomeGenerator()

    @DisplayName("When generating genome of given length")
    @Nested
    inner class WhenGeneratingGenome {
        private val length = 10L
        private val allowedSymbols = arrayOf('N', 'G', 'C', 'T', 'A')

        @Test
        fun `then genome that consists of {N,G,C,T,A} is returned`() {

            generator.generate(length)
                    .apply {
                        this.forEach {
                            Assertions.assertTrue { allowedSymbols.contains(it) }
                        }
                    }
        }

        @Test
        fun `then genome has ordered length`() {
            generator.generate(length)
                    .apply {
                        Assertions.assertEquals(length, this.length)
                    }
        }
    }
}