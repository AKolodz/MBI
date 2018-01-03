import file_interactor.FileInteractorImpl
import genome.GenomeName
import file_interactor.GenomeServiceImpl
import genome.RandomGenomeGenerator

fun main(args: Array<String>) {
//    val genomeGenerator = RandomGenomeGenerator()
//    val random = genomeGenerator.generate(50)
//    println(bigRandom)

    val service = GenomeServiceImpl(FileInteractorImpl())
//    var ecoli = service.load(GenomeName.ECOLI)
//    ecoli = ecoli.filter { it.isLetter() }
//    var rand= service.load(null, "SmallRand")

//    var y = service.load(GenomeName.HIV)
//    service.save(GenomeName.HIV, y)

//    println(rand)
}