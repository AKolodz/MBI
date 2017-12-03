package file_interactor

import java.io.File

interface FileInteractor {
    fun readFrom(filename: String): String
    fun writeTo(filename: String, content: String)
}

class FileInteractorImpl : FileInteractor {
    override fun readFrom(filename: String): String =
            File(filename)
                    .inputStream()
                    .bufferedReader()
                    .use {
                        it.readText()
                    }

    override fun writeTo(filename: String, content: String) {
        File(filename)
                .printWriter()
                .use {
                    it.println(content)
                }
    }
}