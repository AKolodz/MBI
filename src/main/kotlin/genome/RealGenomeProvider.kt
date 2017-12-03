package genome

import file_interactor.FileInteractor
import java.lang.invoke.WrongMethodTypeException

class RealGenomeProvider(private val fileInteractor: FileInteractor) : GenomeProvider {

    private val genomes: Map<GenomeName, String> =
            mapOf(
                    GenomeName.ECOLI to "ecoli.txt"
            )

    override fun provide(name: GenomeName): String =
            genomes[name]
                    .run {
                        if (this == null)
                            throw IllegalArgumentException("Filename for chosen genome name doesn't exist")
                        fileInteractor.readFrom(this)
                    }

    override fun generate(length: Long): String =
            throw WrongMethodTypeException("Provider can not generate genome. Use RandomGenomeGenerator instead.")
}

enum class GenomeName {
    ECOLI
}