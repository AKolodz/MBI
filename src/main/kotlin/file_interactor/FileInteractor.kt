package file_interactor

import java.io.File

/**
 * Interface that declares methods that allow for interacting with external data source.
 */
interface FileInteractor {
    fun readFrom(filename: String): String
    fun writeTo(filename: String, content: String)
}

/**
 * Class that implements the way of interacting with external data source (more specific: text files).
 *
 * @constructor Creates an instance of FileInteractorImpl
 */
class FileInteractorImpl : FileInteractor {

    /**
     * Reads from File given by path [filename].
     */
    override fun readFrom(filename: String): String =
            File(filename)
                    .inputStream()
                    .bufferedReader()
                    .use {
                        it.readText()
                    }

    /**
     * Writes [content] to File under given path [filename].
     */
    override fun writeTo(filename: String, content: String) {
        File(filename)
                .printWriter()
                .use {
                    it.println(content)
                }
    }
}