package rearrangement

/**
 * Class that adds rearrangements to given genome.
 *
 * @constructor Creates an instance of RearrangementsMaker
 * @property factory provides instances of different [RearrangementStrategy]
 */
class RearrangementsMaker(private val factory : StrategyFactory) {

    /**
     * Rearranges [genome] on the distance described [startIndex] and [rearrangementLength] in the way specified by [type]
     * @return Nucleotide sequence
     * @throws IllegalArgumentException if given arguments have invalid absolute or relative values
     */
    fun rearrange(genome: String, startIndex: Int = 0, rearrangementLength: Int, type: RearrangementType): String {
        if (startIndex < 0 || startIndex >= genome.length)
            throw IllegalArgumentException("Start index out of bound")
        if ((genome.length - startIndex) < rearrangementLength || rearrangementLength <= 0)
            throw IllegalArgumentException("Invalid value of rearrangement length parameter")

        return factory
                .provideStrategy(type)
                .run {
                    this.rearrange(genome, startIndex, rearrangementLength)
                }
    }
}


