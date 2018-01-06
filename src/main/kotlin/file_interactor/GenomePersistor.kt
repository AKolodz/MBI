package file_interactor

interface GenomePersistor{
    fun save(fileName: String, content: String)
}