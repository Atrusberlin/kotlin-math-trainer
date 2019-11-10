package de.dranke.math.trainer.tasks

import kotlin.random.Random

open class NumberGenerator {
    private var random: Random = Random(System.currentTimeMillis())

    open fun next(lowerBoundary: Int, upperBoundary: Int): Int {
        return when {
            lowerBoundary == upperBoundary -> 0
            lowerBoundary > upperBoundary -> 0
            else -> random.nextInt(lowerBoundary, upperBoundary)
        }
    }

}
