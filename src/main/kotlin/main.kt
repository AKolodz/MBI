import file_interactor.FileInteractorImpl
import file_interactor.GenomeService
import genome.GenomeName
import genome.GenomeProviderImpl
import rearrangement.RearrangementType

fun main(args: Array<String>) {

    val service = GenomeService(FileInteractorImpl())
    val provider = GenomeProviderImpl(service)

    val genome = provider.provide(filename = "aaa")
            .apply { println(this) }



//    MainFunctions.addSpecifiedTypeRearrangements(genome, 1, 10, 500000, RearrangementType.INVERSION)
//            .apply {
//                service.save("rend500k_1x_500000i500000_10_inv", this)
//            }
}




