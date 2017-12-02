package rearrangement

interface RearrangementStrategy {
    fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String
}

class DeletionInserter : RearrangementStrategy {
    override fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String =
            genome
                    .filterIndexed { index, _ ->
                        index !in startIndex..(startIndex + rearrangementLength - 1)
                    }
}


class InversionInserter : RearrangementStrategy {
    override fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String {
        if ((genome.length - startIndex) <= rearrangementLength || startIndex >= genome.length || startIndex < 0)
            throw IllegalArgumentException("Incorrect value of rearrangement length or starting point parameter")

        return genome
    }
}

class DuplicationInserter : RearrangementStrategy {
    override fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String {
        if ((genome.length - startIndex) <= rearrangementLength || startIndex >= genome.length || startIndex < 0)
            throw IllegalArgumentException("Incorrect value of rearrangement length or starting point parameter")

        return genome
    }
}

class TranspositionInserter : RearrangementStrategy {
    override fun rearrange(genome: String, startIndex: Int, rearrangementLength: Int): String {
        if ((genome.length - startIndex) <= rearrangementLength || startIndex >= genome.length || startIndex < 0)
            throw IllegalArgumentException("Incorrect value of rearrangement length or starting point parameter")

        return genome
    }
}
