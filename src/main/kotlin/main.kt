import genome.RandomGenomeGenerator

fun main(args: Array<String>){
    val generatorRandom: RandomGenomeGenerator = RandomGenomeGenerator()
    println(generatorRandom.generate(20))
}