package genome

/**
 * Interface that declares use case method for providing genome.
 */
interface GenomeProvider {
    fun provide(name: GenomeName? = null, filename: String? = null): String
}
