package genome

import org.junit.jupiter.api.*
import org.mockito.BDDMockito

@DisplayName("Given instance of GenomeProviderImpl")
internal class GenomeProviderImplTest {

    private lateinit var provider: GenomeProviderImpl
    private lateinit var service: GenomeLoader

    @BeforeEach
    fun setUp() {
        service = BDDMockito.mock(GenomeLoader::class.java)
        provider = GenomeProviderImpl(service)
    }

    @Nested
    @DisplayName("When requesting by no params")
    inner class EmptyRequest {


        @Test
        fun `then IllegalArgumentException is thrown`() {
            Assertions.assertThrows(IllegalArgumentException::class.java, {
                provider.provide()
            })
        }
    }

    @Nested
    @DisplayName("When requesting for genome by GenomeName")
    inner class WhenRequestingByGenomeName {

        @BeforeEach
        fun setUp() {
            BDDMockito.given(service.load("genomes/ecoli.txt"))
                    .willReturn("aaa")
        }

        @Test
        fun `then GenomeService is calling for data from specific catalog`() {
            provider.provide(GenomeName.ECOLI)
            BDDMockito.verify(service).load("genomes/ecoli.txt")
        }

        @Test
        fun `then genome is returned`() {
            provider.provide(GenomeName.ECOLI)
                    .apply {
                        Assertions.assertEquals("aaa", this)
                    }
        }
    }

    @Nested
    @DisplayName("When requesting for genome by filepath...")
    inner class WhenRequestingByFilepath {

        @Nested
        @DisplayName("and path is incorrect")
        inner class IncorrectPath {
            @BeforeEach
            fun setUp() {
                BDDMockito.willThrow(IllegalArgumentException()).
                        given(service).load("incorrectPath")
            }

            @Test
            fun `then FileNotFoundException is thrown`() {
                Assertions.assertThrows(IllegalArgumentException::class.java, {
                    provider.provide(filename = "incorrectPath")
                })
            }
        }

        @Nested
        @DisplayName("and path is correct")
        inner class CorrectPath {

            @BeforeEach
            fun setUp() {
                BDDMockito.given(service.load("correctPath"))
                        .willReturn("aaa")
            }

            @Test
            fun `then GenomeService is called`() {
                provider.provide(filename = "correctPath")
                BDDMockito.verify(service).load("correctPath")
            }

            @Test
            fun `then genome is returned`() {
                provider.provide(filename = "correctPath")
                        .apply {
                            Assertions.assertEquals("aaa", this)
                        }
            }
        }

    }
}