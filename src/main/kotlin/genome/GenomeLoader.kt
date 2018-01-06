package genome

interface GenomeLoader {
    fun load(fileName: String): String
}