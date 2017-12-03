package genome

import file_interactor.FileInteractor
import java.lang.invoke.WrongMethodTypeException

class RealGenomeProvider(private val service : GenomeService) : GenomeProvider {

    override fun provide(name: GenomeName): String = service.load(name)

    override fun generate(length: Long): String =
            throw WrongMethodTypeException("Provider can not generate genome. Use RandomGenomeGenerator instead.")
}

enum class GenomeName {
    ECOLI
}