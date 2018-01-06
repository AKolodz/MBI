package genome

interface GenomeProvider {
    fun provide(name: GenomeName? = null, filename: String? = null): String
}
