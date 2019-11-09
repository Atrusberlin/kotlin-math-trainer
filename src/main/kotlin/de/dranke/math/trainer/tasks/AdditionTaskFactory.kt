package de.dranke.math.trainer.tasks

class AdditionTaskFactory {
    val operation: Char = '+'

    fun createTask(): Task {
        return Task(1, 2, operation);
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