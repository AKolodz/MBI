package genome

import file_interactor.GenomeService

/**
 * Interface that declares methods used by.
 */
interface GenomeGenerator {
    fun generate(length: Long): String
}