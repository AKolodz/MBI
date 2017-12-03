package file_interactor

interface FileInteractor {
    fun readFrom(filename: String): String
    fun writeTo(filename: String, content: String)
}