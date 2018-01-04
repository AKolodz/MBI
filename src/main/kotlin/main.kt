import file_interactor.FileInteractorImpl
import file_interactor.GenomeServiceImpl
import genome.GenomeName
import genome.GenomeProviderImpl

fun main(args: Array<String>) {

    val service = GenomeServiceImpl(FileInteractorImpl())
    val provider = GenomeProviderImpl(service)

    val genome = provider.provide(GenomeName.ECOLI)
    MainFunctions.addMultipleTypeRearrangements(genome, 10, 100000, 100000)
            .apply {
                service.save("test", this)
            }
}




