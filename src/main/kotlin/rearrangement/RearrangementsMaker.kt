package rearrangement

class RearrangementsMaker {
    private val factory = RearrangementStrategyFactory()

    fun rearrange(genome: String, startIndex: Int = 0, rearrangementLength: Int, type: RearrangementType): String {
        if (startIndex < 0 || startIndex >= genome.length)
            throw IllegalArgumentException("Start index out of bound")
        if ((genome.length - startIndex) < rearrangementLength)
            throw IllegalArgumentException("Invalid value of rearrangement length parameter")

        return factory
                .provideStrategy(type)
                .run {
                    this.rearrange(genome, startIndex, rearrangementLength)
                }
    }
}


