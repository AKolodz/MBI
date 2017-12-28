package file_interactor

import genome.GenomeName

interface GenomeService {
    fun save(fileName: GenomeName? = null, customFilename: String? = null, content: String)
    fun load(fileName: GenomeName? = null, customFilename: String? = null): String
}

class GenomeServiceImpl(private val interactor: FileInteractor) : GenomeService {
    private val genomePaths: Map<GenomeName, String> =
            mapOf(
                    GenomeName.ECOLI to "ecoli.txt",
                    GenomeName.MS2 to "virusMS2.txt",
                    GenomeName.HIV to "hiv.txt",
                    GenomeName.CHROMOSOME_Y to "chromosomeY.txt",
                    GenomeName.BIG_RAND to "bigRand.txt",
                    GenomeName.MEDIUM_RAND to "mediumRand.txt"
            )

    override fun save(fileName: GenomeName?, customFilename: String?, content: String) =
            if (fileName != null) {
                genomePaths[fileName].run {
                    if (this == null)
                        throw IllegalArgumentException("No path for given genome name")
                    interactor.writeTo(this, content)
                }
            } else {
                interactor.writeTo(customFilename
                        ?: throw IllegalArgumentException("Both filenames can't be null"),
                        content)
            }

    override fun load(fileName: GenomeName?, customFilename: String?): String =
            if (fileName != null) {
                genomePaths[fileName].run {
                    if (this == null)
                        throw IllegalArgumentException("No path for given genome name")
                    interactor.readFrom(this)
                }
            } else {
                interactor.readFrom(customFilename
                        ?: throw IllegalArgumentException(" Both filenames can't be null"))
            }

}