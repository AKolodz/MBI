import file_interactor.FileInteractorImpl
import genome.GenomeName
import file_interactor.GenomeServiceImpl
import genome.RandomGenomeGenerator

fun main(args: Array<String>) {
    val genomeGenerator = RandomGenomeGenerator()
//    val bigRandom = genomeGenerator.generate(500000)
//    println(bigRandom)


    val service = GenomeServiceImpl(FileInteractorImpl())
    var ecoli = service.load(GenomeName.ECOLI)
    ecoli = ecoli.filter { it.isLetter() }
    service.save(GenomeName.ECOLI, ecoli)

//    var y = service.load(GenomeName.HIV)
//
//    y= y.filter { it.isLetter() }

//    service.save(GenomeName.HIV, y)
//    println(y)
}