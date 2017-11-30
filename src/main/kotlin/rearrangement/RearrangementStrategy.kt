package rearrangement

interface RearrangementStrategy {
    fun rearrange(genome: String, rearrangementLength: Int): String
}

class DeletionInserter : RearrangementStrategy {
    override fun rearrange(genome: String, rearrangementLength: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class InversionInserter : RearrangementStrategy {
    override fun rearrange(genome: String, rearrangementLength: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class DuplicationInserter : RearrangementStrategy {
    override fun rearrange(genome: String, rearrangementLength: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class TranspositionInserter : RearrangementStrategy {
    override fun rearrange(genome: String, rearrangementLength: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
