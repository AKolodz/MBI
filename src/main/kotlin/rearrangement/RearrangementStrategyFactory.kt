package rearrangement

/**
 * Interface of factory class that should provide [RearrangementStrategy] implementations.
 */
interface StrategyFactory{
    fun provideStrategy(type: RearrangementType) : RearrangementStrategy
}

/**
 * Class that creates and provides instances of classes that implements [RearrangementStrategy] interface.
 *
 * @constructor Creates an instance of RearrangementStrategyFactory.
 */
class RearrangementStrategyFactory : StrategyFactory {

    private val strategies: Map<RearrangementType, RearrangementStrategy> =
            mapOf(
                    RearrangementType.DELETION to DeletionInserter(),
                    RearrangementType.DUPLICATION to DuplicationInserter(),
                    RearrangementType.INVERSION to InversionInserter(),
                    RearrangementType.TRANSPOSITION to TranspositionInserter()
            )

    /**
     * Provides instance of class performing rearrangement of given [type]
     * @return Class that performs rearrangement
     */
    override fun provideStrategy(type: RearrangementType): RearrangementStrategy =
            strategies[type] ?:
                    throw IllegalArgumentException()
}