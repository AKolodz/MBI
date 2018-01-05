package genome

import file_interactor.GenomeService

class GenomeProviderImpl(private val service: GenomeService) : GenomeProvider {

    private val genomePaths: Map<GenomeName, String> =
            mapOf(
                    GenomeName.ECOLI to "ecoli.txt",
                    GenomeName.MS2 to "virusMS2.txt",
                    GenomeName.HIV to "hiv.txt",
                    GenomeName.CHROMOSOME_Y to "chromosomeY.txt",
                    GenomeName.RAND_500K to "rand500k.txt",
                    GenomeName.MEDIUM_RAND to "mediumRand.txt"
            )

    override fun provide(name: GenomeName): String =
            service.load(genomePaths[name]
                    ?: throw IllegalArgumentException("File under given GenomeName doesn't exist"))
}