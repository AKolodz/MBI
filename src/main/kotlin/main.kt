import genome.RandomGenomeGenerator
import rearrangement.RearrangementType
import rearrangement.RearrangementsMaker

fun main(args: Array<String>) {
    val genomeGenerator: RandomGenomeGenerator = RandomGenomeGenerator()
    println(genomeGenerator.generate(20))

    val rearranger = RearrangementsMaker()
    val string = rearranger.rearrange("Genom", 4, 1, RearrangementType.INVERSION)
    println(string)
}