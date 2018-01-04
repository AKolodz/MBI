import file_interactor.FileInteractorImpl
import file_interactor.GenomeService
import file_interactor.GenomeServiceImpl
import genome.GenomeName
import genome.GenomeProvider
import genome.GenomeProviderImpl
import rearrangement.RearrangementStrategyFactory
import rearrangement.RearrangementType
import rearrangement.RearrangementsMaker

fun main(args: Array<String>) {

    val rearrangementsMaker = RearrangementsMaker(RearrangementStrategyFactory())
    val service = GenomeServiceImpl(FileInteractorImpl())
    val provider = GenomeProviderImpl(service)

    addRearrangementsAndSave(provider, rearrangementsMaker, service, "ecoli_30x_4500000i100000_10_inv",
            30, 10, 100000, RearrangementType.INVERSION)
}

fun addRearrangementsAndSave(provider: GenomeProvider,
                             rearrangementsMaker: RearrangementsMaker,
                             service: GenomeService,
                             filename: String,
                             numberOfRearrangements: Int,
                             rearrangementLength: Int,
                             step: Int,
                             type: RearrangementType) {

    provider.provide(GenomeName.ECOLI)
            .run {
                var genome = this
                val length = genome.length
                for (i in 1 .. numberOfRearrangements) {
                    genome = rearrangementsMaker.rearrange(genome, length - i * step, rearrangementLength, type)
                }
                genome
            }.apply { service.save(filename, this) }
}
