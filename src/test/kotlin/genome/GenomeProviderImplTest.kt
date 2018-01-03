package genome

import file_interactor.GenomeService
import org.junit.jupiter.api.*
import org.mockito.BDDMockito

@DisplayName("Given instance of GenomeProviderImpl")
internal class GenomeProviderImplTest {

    private lateinit var provider: GenomeProviderImpl
    private lateinit var service: GenomeService

    @BeforeEach
    fun setUp() {
        service = BDDMockito.mock(GenomeService::class.java)
        provider = GenomeProviderImpl(service)
    }

    @Nested
    @DisplayName("When requesting for genome and filepath under given name exists")
    inner class WhenRequestingExisting {

        @BeforeEach
        fun setUp() {
            BDDMockito.given(service.load("ecoli.txt"))
                    .willReturn("aaa")
        }

        @Test
        fun `then GenomeService is called`() {
            provider.provide(GenomeName.ECOLI)
            BDDMockito.verify(service).load("ecoli.txt")
        }

        @Test
        fun `then genome is returned`() {
            provider.provide(GenomeName.ECOLI)
                    .apply {
                        Assertions.assertEquals("aaa", this)
                    }
        }
    }
}