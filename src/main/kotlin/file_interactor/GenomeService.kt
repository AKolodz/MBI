package file_interactor

interface GenomeService {
    fun save(fileName: String, content: String)
    fun load(fileName: String): String
}

class GenomeServiceImpl(private val interactor: FileInteractor) : GenomeService {

    override fun save(fileName: String, content: String) =
            interactor.writeTo(fileName, content)

    override fun load(fileName: String): String =
            interactor.readFrom(fileName)


}