package rearrangement

interface StrategyFactory{
    fun provideStrategy(type: RearrangementType) : RearrangementStrategy
}

class RearrangementStrategyFactory : StrategyFactory {

    private val strategies: Map<RearrangementType, RearrangementStrategy> =
            mapOf(
                    RearrangementType.DELETION to DeletionInserter(),
                    RearrangementType.DUPLICATION to DuplicationInserter(),
                    RearrangementType.INVERSION to InversionInserter(),
                    RearrangementType.TRANSPOSITION to TranspositionInserter()
            )

    override fun provideStrategy(type: RearrangementType): RearrangementStrategy =
            strategies[type] ?:
                    throw IllegalArgumentException()
}