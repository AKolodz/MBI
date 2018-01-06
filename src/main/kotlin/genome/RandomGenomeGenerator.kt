package genome

/**
 * Class used for generating random nucleotide sequences basing on {A, C, G, T, N} alphabet.
 *
 * @constructor Creates an instance of RandomGenomeGenerator.
 */
class RandomGenomeGenerator : GenomeGenerator {
    private val allowedSymbols = arrayOf('N', 'G', 'C', 'T', 'A')

    /**
     * Generates a random nucleotide sequence of the given [length].
     * @return Generated sequence.
     */
    override fun generate(length: Long): String {
        var genome = ""
        for (counter in 1..length) {
            genome += (allowedSymbols[provideRandomInt()])
        }
        return genome
    }

    private fun provideRandomInt(): Int =
            Math.floor(Math.random() * allowedSymbols.size).toInt()

}