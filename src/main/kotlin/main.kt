import genome.RandomGenomeGenerator

fun main(args: Array<String>){
    val genomeGenerator: RandomGenomeGenerator = RandomGenomeGenerator()
    println(genomeGenerator.generate(20))
}