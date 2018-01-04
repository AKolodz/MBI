import file_interactor.FileInteractorImpl
import file_interactor.GenomeServiceImpl
import genome.GenomeName
import genome.GenomeProviderImpl
import rearrangement.RearrangementStrategyFactory
import rearrangement.RearrangementType
import rearrangement.RearrangementsMaker

fun main(args: Array<String>) {

    val rearrangementsMaker = RearrangementsMaker(RearrangementStrategyFactory())
    val service = GenomeServiceImpl(FileInteractorImpl())
    val provider = GenomeProviderImpl(service)

    provider.provide(GenomeName.ECOLI)
            .apply {
                rearrangementsMaker.rearrange(this,10000,100000,RearrangementType.DUPLICATION)
                        .apply { service.save("ecoli_10000_100000_dup",this) }
            }

}