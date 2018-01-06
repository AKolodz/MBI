package file_interactor

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito

@DisplayName("Given instance of an GenomeServiceImpl")
internal class GenomeServiceTest {

    private lateinit var fileInteractor : FileInteractor
    private lateinit var service : GenomeService

    @BeforeEach
    fun setUp(){
        fileInteractor = BDDMockito.mock(FileInteractor::class.java)
        service = GenomeService(fileInteractor)
    }

    @Nested
    @DisplayName("When loading genome")
    inner class WhenLoading{

        private val filename = "filename"
        private val genome = "AACCGGTT"

        @BeforeEach
        fun setUp(){
            BDDMockito.given(fileInteractor.readFrom(filename))
                    .willReturn(genome)
        }

        @Test
        fun `then FileInteractor is called`(){
            service.load(filename)
            BDDMockito.verify(fileInteractor).readFrom(filename)
        }

        @Test
        fun `then genome is returned`(){
            service.load(filename)
                    .apply {
                        assertEquals(genome, this)
                    }

        }
    }

    @Nested
    @DisplayName("When saving genome")
    inner class WhenSaving{

        private val filename = "filename"
        private val genome = "AACCGGTT"

        @Test
        fun `then FileInteractor is called`(){
            service.save(filename,genome)
            BDDMockito.verify(fileInteractor).writeTo(filename, genome)
        }
    }

}