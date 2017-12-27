import file_interactor.FileInteractorImpl
import genome.GenomeName
import file_interactor.GenomeServiceImpl
import genome.RandomGenomeGenerator

fun main(args: Array<String>) {
    val genomeGenerator = RandomGenomeGenerator()
    println(genomeGenerator.generate(20))

    val service = GenomeServiceImpl(FileInteractorImpl())
    var y = service.load(GenomeName.CHROMOSOME_Y)

    y= y.filter { it.isLetter() }

    service.save(GenomeName.CHROMOSOME_Y, y)
    println(y)
}