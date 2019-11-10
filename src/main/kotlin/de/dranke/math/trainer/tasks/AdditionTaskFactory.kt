package de.dranke.math.trainer.tasks

class AdditionTaskFactory() {
    val operation: Char = '+'
    private lateinit var numberGenerator: NumberGenerator
    private var lowerBoundary: Int = 0
    private var upperBoundary: Int = 10

    constructor(numberGenerator: NumberGenerator, lowerBoundary: Int, upperBoundary: Int) : this() {
        this.numberGenerator = numberGenerator
        this.lowerBoundary = lowerBoundary
        this.upperBoundary = upperBoundary
    }


    fun createTask(): Task {
        val addend1 = numberGenerator.next(lowerBoundary, upperBoundary)
        val lowerBoundaryNew = calculateLowerBoundaryForSecondAddend(addend1)
        val addend2 = numberGenerator.next(lowerBoundaryNew, calculateUperBoundaryForSecondAddend(addend1, lowerBoundaryNew))
        return Task(addend1, addend2, operation);
    }

    private fun calculateLowerBoundaryForSecondAddend(firstAddend: Int): Int {
        val newValue = upperBoundary - firstAddend
        return when {
            lowerBoundary > newValue -> 0
            else -> lowerBoundary
        }
    }

    private fun calculateUperBoundaryForSecondAddend(firstAddend: Int, lowerBoundaryNew: Int): Int {
        val newValue = upperBoundary - firstAddend
        return when {
            newValue < lowerBoundaryNew -> lowerBoundaryNew
            else -> newValue
        }
    }

    class Task(val addend1: Int, val addend2: Int, val operation: Char) {

        init {
//            println(toString())
        }

        override fun toString(): String {
            return "New Task: $addend1 $operation $addend2 = ?"
        }

    }
}