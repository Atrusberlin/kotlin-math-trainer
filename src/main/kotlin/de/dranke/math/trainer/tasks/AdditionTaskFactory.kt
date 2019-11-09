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
        val addend2 = numberGenerator.next(lowerBoundary, upperBoundary - addend1)
        return Task(addend1, addend2, operation);
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