package genome

import file_interactor.FileInteractor

interface GenomeService {
    fun save(name: GenomeName, content: String)
    fun load(name: GenomeName): String
}

class GenomeServiceImpl(private val interactor: FileInteractor) : GenomeService {
    private val genomePaths: Map<GenomeName, String> =
            mapOf(
                    GenomeName.ECOLI to "ecoli.txt"
            )

    override fun save(name: GenomeName, content: String) =
            genomePaths[name].run {
                if (this == null)
                    throw IllegalArgumentException("No path for given genome name")
                interactor.writeTo(this, content)
            }

    override fun load(name: GenomeName): String =
            genomePaths[name].run {
                if (this == null)
                    throw IllegalArgumentException("No path for given genome name")
                interactor.readFrom(this)
            }
}