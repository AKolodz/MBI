import file_interactor.FileInteractorImpl
import genome.GenomeName
import genome.GenomeService
import genome.GenomeServiceImpl
import genome.RandomGenomeGenerator
import rearrangement.RearrangementType
import rearrangement.RearrangementsMaker
import java.io.File
import java.io.PrintWriter

fun main(args: Array<String>) {
    val genomeGenerator: RandomGenomeGenerator = RandomGenomeGenerator()
    println(genomeGenerator.generate(20))

    val service = GenomeServiceImpl(FileInteractorImpl())
    service.save(GenomeName.ECOLI,"ECOLI")

    println(service.load(GenomeName.ECOLI))
}