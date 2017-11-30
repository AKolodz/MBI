package rearrangement

class RearrangementsMaker {
    private val factory = RearrangementStrategyFactory()

    fun rearrange(genome: String, rearrangementLength: Int, type: RearrangementType): String =
            factory
                    .provideStrategy(type)
                    .run {
                        this.rearrange(genome, rearrangementLength)
                    }

}


