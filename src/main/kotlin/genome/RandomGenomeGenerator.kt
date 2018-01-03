package genome

class RandomGenomeGenerator : GenomeGenerator {
    private val allowedSymbols = arrayOf('N', 'G', 'C', 'T', 'A')

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