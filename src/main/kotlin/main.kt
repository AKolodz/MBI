import file_interactor.FileInteractorImpl
import genome.GenomeName
import genome.GenomeServiceImpl
import genome.RandomGenomeGenerator

fun main(args: Array<String>) {
    val genomeGenerator = RandomGenomeGenerator()
    println(genomeGenerator.generate(20))

    val service = GenomeServiceImpl(FileInteractorImpl())
    service.save(GenomeName.ECOLI, "ECOLI")

    println(service.load(GenomeName.ECOLI))
}