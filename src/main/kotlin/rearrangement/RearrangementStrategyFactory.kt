package rearrangement


class RearrangementStrategyFactory {

    private val strategies: Map<RearrangementType, RearrangementStrategy> =
            mapOf(
                    RearrangementType.DELETION to DeletionInserter(),
                    RearrangementType.DUPLICATION to DuplicationInserter(),
                    RearrangementType.INVERSION to InversionInserter(),
                    RearrangementType.TRANSPOSITION to TranspositionInserter()
            )

    fun provideStrategy(type: RearrangementType): RearrangementStrategy =
            strategies[type] ?:
                    throw IllegalArgumentException()
}