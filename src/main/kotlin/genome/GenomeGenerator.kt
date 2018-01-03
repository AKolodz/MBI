package genome

interface GenomeGenerator {
    fun generate(length: Long): String
}