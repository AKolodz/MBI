package genome

class RandomGenomeGenerator : GenomeProvider {
    private val allowedSymbols = arrayOf('N', 'G', 'C', 'T', 'A')

    override fun generate(length: Long): String {
        var genome = ""
        for (counter in 1..length) {
            genome += (allowedSymbols[provideRandomInt()])
        }
        return genome
    }

    override fun provide(name: GenomeName): String =
            throw IllegalArgumentException("Random Genome Generator don't have access to real genomes. Use another GenomeProvider")

    private fun provideRandomInt(): Int =
            Math.floor(Math.random() * allowedSymbols.size).toInt()

}