import file_interactor.FileInteractorImpl
import file_interactor.GenomeServiceImpl
import genome.GenomeName
import genome.GenomeProviderImpl
import rearrangement.RearrangementType

fun main(args: Array<String>) {

    val service = GenomeServiceImpl(FileInteractorImpl())
    val provider = GenomeProviderImpl(service)

    val genome = provider.provide(GenomeName.RAND_500K)
    MainFunctions.addSpecifiedTypeRearrangements(genome, 1, 10, 500000, RearrangementType.INVERSION)
            .apply {
                service.save("rend500k_1x_500000i500000_10_inv", this)
            }
}




