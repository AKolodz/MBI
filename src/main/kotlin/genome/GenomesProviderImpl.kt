package genome

/**
 * Class that provides genome sequences.
 *
 * @constructor Creates an instance of GenomeProviderImpl.
 * @property service Calls for genomes from data source.
 */
class GenomeProviderImpl(private val service: GenomeLoader) : GenomeProvider {

    private val genomePaths: Map<GenomeName, String> =
            mapOf(
                    GenomeName.ECOLI to "genomes/ecoli.txt",
                    GenomeName.MS2 to "genomes/virusMS2.txt",
                    GenomeName.HIV to "genomes/hiv.txt",
                    GenomeName.CHROMOSOME_Y to "genomes/chromosomeY.txt",
                    GenomeName.RAND_500K to "genomes/rand500k.txt",
                    GenomeName.RAND_50K to "genomes/rand50k.txt",
                    GenomeName.RAND_50 to "genomes/rand50.txt"
            )

    /**
     * Provides nucleotide sequence saved under specific [filename] or filepath specified by [name].
     * @return Nucleotide sequence.
     */
    override fun provide(name: GenomeName?, filename: String?): String =
            if (name != null) {
                service.load(genomePaths[name]
                        ?: throw IllegalArgumentException("File under given GenomeName doesn't exist"))
            } else {
                service.load(filename
                        ?: throw IllegalArgumentException("You must specify genome name or filepath"))
            }

}