import rearrangement.RearrangementStrategyFactory
import rearrangement.RearrangementType
import rearrangement.RearrangementsMaker

class MainFunctions {

    companion object {

        fun addMultipleTypeRearrangements(genome: String, numberOfRearrangements: Int, rearrangementLength: Int, step: Int): String =
                genome.run {
                    val rearrangements = mapOf(
                            0 to RearrangementType.DUPLICATION,
                            1 to RearrangementType.DELETION,
                            2 to RearrangementType.TRANSPOSITION,
                            3 to RearrangementType.INVERSION)
                    val rearrangementsMaker = RearrangementsMaker(RearrangementStrategyFactory())
                    var rearrangedGenome = this
                    val length = this.length

                    for (i in 1..numberOfRearrangements) {
                        rearrangedGenome = rearrangementsMaker.rearrange(rearrangedGenome, length - i * step, rearrangementLength, rearrangements[provideRandomInt(3)]!!)
                    }
                    rearrangedGenome
                }

        private fun provideRandomInt(maxNumber: Int): Int =
                Math.floor(Math.random() * (maxNumber + 1)).toInt()

        fun addSpecifiedTypeRearrangements(genome: String,
                                           numberOfRearrangements: Int,
                                           rearrangementLength: Int,
                                           step: Int,
                                           type: RearrangementType): String =
                genome.run {
                    val rearrangementsMaker = RearrangementsMaker(RearrangementStrategyFactory())
                    var rearrangedGenome = this
                    val length = rearrangedGenome.length
                    for (i in 1..numberOfRearrangements) {
                        rearrangedGenome = rearrangementsMaker.rearrange(rearrangedGenome, length - i * step, rearrangementLength, type)
                    }
                    rearrangedGenome
                }
    }

}