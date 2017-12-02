package rearrangement

import java.lang.StringBuilder

interface RearrangementStrategy {
    fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String
}

class DeletionInserter : RearrangementStrategy {
    override fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String =
            genome.removeRange(startIndex, startIndex + rearrangementLength)
}


class InversionInserter : RearrangementStrategy {
    override fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String =
            genome
                    .substring(startIndex, startIndex + rearrangementLength)
                    .reversed()
                    .run {
                        genome.replaceRange(startIndex, startIndex + rearrangementLength, this)
                    }
}

class DuplicationInserter : RearrangementStrategy {
    override fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String =
            genome + genome.substring(startIndex, startIndex + rearrangementLength)
}

class TranspositionInserter : RearrangementStrategy {
    override fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String {
        val substring = genome.substring(startIndex, startIndex+rearrangementLength)
        genome.removeRange(startIndex,startIndex+rearrangementLength)
        return StringBuilder(genome).insert(random()!=startIndex,"").toString()
    }
}
