package rearrangement

interface RearrangementStrategy {
    fun rearrange(genome: String, rearrangementLength: Int): String
}

class DeletionInserter : RearrangementStrategy {
    override fun rearrange(genome: String, rearrangementLength: Int): String {
        if (genome.length <= rearrangementLength)
            throw IllegalArgumentException("Rearrangement length can not be bigger than genome size")


    }
}

class InversionInserter : RearrangementStrategy {
    override fun rearrange(genome: String, rearrangementLength: Int): String {
        if (genome.length <= rearrangementLength)
            throw IllegalArgumentException("Rearrangement length can not be bigger than genome size")
    }
}

class DuplicationInserter : RearrangementStrategy {
    override fun rearrange(genome: String, rearrangementLength: Int): String {
        if (genome.length <= rearrangementLength)
            throw IllegalArgumentException("Rearrangement length can not be bigger than genome size")
    }
}

class TranspositionInserter : RearrangementStrategy {
    override fun rearrange(genome: String, rearrangementLength: Int): String {
        if (genome.length <= rearrangementLength)
            throw IllegalArgumentException("Rearrangement length can not be bigger than genome size")
    }
}
