package rearrangement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito

@DisplayName("Given an instance of RearrangementsMaker")
internal class RearrangementsMakerTest {

    private lateinit var factory: StrategyFactory
    private lateinit var rearrangementsMaker: RearrangementsMaker

    @BeforeEach
    fun setUp() {
        factory = BDDMockito.mock(StrategyFactory::class.java)
        rearrangementsMaker = RearrangementsMaker(factory)
    }

    @Nested
    @DisplayName("When rearranging genome")
    inner class WhenRearranging {

        private val genome = "AACCGGTT"
        private val rearrangedGenome = "CGGTT"
        private val strategy = BDDMockito.mock(RearrangementStrategy::class.java)

        @BeforeEach
        fun setUp() {
            BDDMockito.given(factory.provideStrategy(RearrangementType.DELETION))
                    .willReturn(strategy)
            BDDMockito.given(strategy.rearrange(genome, 0, 3))
                    .willReturn(rearrangedGenome)
        }

        @Nested
        @DisplayName("When arguments are valid")
        inner class WhenValidArgs {

            @Test
            fun `then RearrangementStrategyFactory is called`() {
                rearrangementsMaker.rearrange(genome, 0, 3, RearrangementType.DELETION)
                BDDMockito.verify(factory).provideStrategy(RearrangementType.DELETION)
            }

            @Test
            fun `then ordered operation is performed`() {
                rearrangementsMaker.rearrange(genome, 0, 3, RearrangementType.DELETION)
                BDDMockito.verify(strategy).rearrange(genome, 0, 3)
            }

            @Test
            fun `then rearranged genome is returned`() {
                rearrangementsMaker.rearrange(genome, 0, 3, RearrangementType.DELETION)
                        .apply { assertEquals(rearrangedGenome, this) }
            }
        }

        @Nested
        @DisplayName("When rearrangement length is greater than genome length minus starting point")
        inner class WhenLengthGreater {

            @Test
            fun `then IllegalArgumentException is thrown`() {
                assertThrows(IllegalArgumentException::class.java, {
                    rearrangementsMaker.rearrange(genome, 0, 9, RearrangementType.DELETION)
                })
            }
        }

        @Nested
        @DisplayName("When arguments are invalid")
        inner class WhenInvalidArgs {
            @Nested
            @DisplayName("When rearrangement length is not positive")
            inner class WhenLengthNotPositive {

                @Test
                fun `then IllegalArgumentException is thrown`() {
                    assertThrows(IllegalArgumentException::class.java, {
                        rearrangementsMaker.rearrange(genome, 0, 0, RearrangementType.DELETION)
                    })
                }
            }

            @Nested
            @DisplayName("When starting point is not less genome length")
            inner class WhenStartingPointTooBig {

                @Test
                fun `then IllegalArgumentException is thrown`() {
                    assertThrows(IllegalArgumentException::class.java, {
                        rearrangementsMaker.rearrange(genome, 8, 1, RearrangementType.DELETION)
                    })
                }
            }

            @Nested
            @DisplayName("When starting point is less than 0")
            inner class WhenStartingPointTooSmall {

                @Test
                fun `then IllegalArgumentException is thrown`() {
                    assertThrows(IllegalArgumentException::class.java, {
                        rearrangementsMaker.rearrange(genome, -2, 2, RearrangementType.DELETION)
                    })
                }
            }
        }
    }
}