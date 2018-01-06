package genome

/**
 * Interface that declares method that should call data source for data stored under given path.
 */
interface GenomeLoader {
    fun load(fileName: String): String
}