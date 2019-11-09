package de.dranke.math.trainer.tasks

import kotlin.random.Random

open class NumberGenerator {
    var random: Random

    init {
        random = Random(40)
    }

    open fun next(lowerBoundary: Int, upperBoundary: Int): Int {
        return random.nextInt(lowerBoundary, upperBoundary)
    }

}
