package rearrangement

import java.lang.StringBuilder

/**
 * Interface of class that should perform some kind of genome rearrangement
 */
interface RearrangementStrategy {
    fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String
}

/**
 * Class that inserts deletion to the given string.
 *
 * @constructor Creates an instance of DeletionInserter.
 */
class DeletionInserter : RearrangementStrategy {

    /**
     * Removes subsequence from [genome] specified by [startIndex] (iterates from 0) and [rearrangementLength].
     * [startIndex]+[rearrangementLength] index is excluded from sequence.
     * @return Rearranged nucleotide sequence.
     */
    override fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String =
            genome.removeRange(startIndex, startIndex + rearrangementLength)
}

/**
 * Class that inserts inversion to the given string.
 *
 * @constructor Creates an instance of InversionInserter.
 */
class InversionInserter : RearrangementStrategy {

    /**
     * Reverses subsequence in [genome] specified by [startIndex] (iterates from 0) and [rearrangementLength].
     * [startIndex]+[rearrangementLength] index is excluded from sequence.
     * @return Rearranged nucleotide sequence.
     */
    override fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String =
            genome.substring(startIndex, startIndex + rearrangementLength)
                    .reversed()
                    .run {
                        genome.replaceRange(startIndex, startIndex + rearrangementLength, this)
                    }
}

/**
 * Class that inserts duplication to the given string.
 *
 * @constructor Creates an instance of DuplicationInserter.
 */
class DuplicationInserter : RearrangementStrategy {

    /**
     * Duplicates subsequence from [genome] specified by [startIndex] (iterates from 0) and [rearrangementLength].
     * Adds this subsequence at the end of the input sequence.
     * [startIndex]+[rearrangementLength] index is excluded from subsequence.
     * @return Rearranged nucleotide sequence.
     */
    override fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String =
            genome + genome.substring(startIndex, startIndex + rearrangementLength)
}

/**
 * Class that inserts transposition to the given string.
 *
 * @constructor Creates an instance of TranspositionInserter.
 */
class TranspositionInserter : RearrangementStrategy {

    /**
     * Cuts subsequence from [genome] specified by [startIndex] (iterates from 0) and [rearrangementLength].
     * Pastes this subsequence in random, other than the origin, place.
     * [startIndex]+[rearrangementLength] index is excluded from subsequence.
     * @return Rearranged nucleotide sequence.
     */
    override fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String {
        val movingPart = genome.substring(startIndex, startIndex + rearrangementLength)
        val base = genome.removeRange(startIndex, startIndex + rearrangementLength)
        return StringBuilder(base)
                .insert(provideRandIndex(base.length, startIndex), movingPart)
                .toString()
    }

    private fun provideRandIndex(range: Int, exception: Int): Int =
            Math.round(Math.random() * range).toInt()
                    .run {
                        if (this != exception)
                            this
                        else {
                            provideRandIndex(range, exception)
                        }
                    }
}

