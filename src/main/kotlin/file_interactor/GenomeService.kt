package file_interactor

import genome.GenomeLoader

/**
 * Class that aggregates methods used by source code to interact with external data source.
 *
 * @constructor Creates an instance of GenomeService
 * @property interactor writes to/reads from data source.
 */
class GenomeService(private val interactor: FileInteractor) : GenomeLoader, GenomePersistor {

    /**
     * Calls [interactor] to write [content] to external data source under given [fileName].
     */
    override fun save(fileName: String, content: String) =
            interactor.writeTo(fileName, content)

    /**
     * Calls [interactor] to read data from external data source given by [fileName].
     * @return Read data.
     */
    override fun load(fileName: String): String =
            interactor.readFrom(fileName)


}