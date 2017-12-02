package genome

interface GenomeProvider {
    fun generate(length: Long): String
    fun provide(name: GenomeName): String
}
