package genome

interface GenomeProvider {
    fun generate(length: Long): String
    fun provideExisting(name: GenomeName): String
}

enum class GenomeName {

}
