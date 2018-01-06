package file_interactor

/**
 * Interface that declares method that should persist data under given path.
 */
interface GenomePersistor{
    fun save(fileName: String, content: String)
}