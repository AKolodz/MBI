package file_interactor

import genome.GenomeLoader

class GenomeService(private val interactor: FileInteractor) : GenomeLoader, GenomePersistor {

    override fun save(fileName: String, content: String) =
            interactor.writeTo(fileName, content)

    override fun load(fileName: String): String =
            interactor.readFrom(fileName)


}