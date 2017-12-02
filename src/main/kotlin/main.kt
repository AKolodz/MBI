import genome.RandomGenomeGenerator
import rearrangement.RearrangementType
import rearrangement.RearrangementsMaker

fun main(args: Array<String>) {
    val genomeGenerator: RandomGenomeGenerator = RandomGenomeGenerator()
    println(genomeGenerator.generate(20))

    val rearranger = RearrangementsMaker()
    val string = rearranger.rearrange("Genom", 1, 4, RearrangementType.TRANSPOSITION)
    println(string)
}