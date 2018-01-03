package genome

interface GenomeProvider {
    fun provide(name: GenomeName): String
}
