package de.dranke.math.trainer.tasks

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class AdditionTaskFactoryTest {

    private var generator: NumberGeneratorStub
    private val taskFactory: AdditionTaskFactory

    class NumberGeneratorStub : NumberGenerator() {
        var current: Int = 0
        var lastLowerBoundary = 0
        var lastUpperBoundary = 0

        override fun next(lowerBoundary: Int, upperBoundary: Int): Int {
            lastLowerBoundary = lowerBoundary
            lastUpperBoundary = upperBoundary
            return current;
        }

    }

    init {
        generator = NumberGeneratorStub()
        taskFactory = AdditionTaskFactory(generator, 0, 10)
    }

    @BeforeTest
    fun setup() {

    }

    @Test
    fun the_task_operation_is_plus() {
        val task = taskFactory.createTask()
        assertEquals('+', task.operation, "Operation has to be '+'")
    }

    @Test
    fun the_first_addent_is_1() {
        generator.current = 1
        val task = taskFactory.createTask()

        assertEquals(1, task.addend1, "First addent has to be 1")
    }

    @Test
    fun the_second_addent_is_2() {
        generator.current = 2
        val task = taskFactory.createTask()

        assertEquals(2, task.addend2, "Second addent has to be 2")
    }

    @Test
    fun the_second_addent_has_to_be_so_small_that_the_sum_will_not_overcome_the_maximum_result() {
        generator.current = 3
        taskFactory.createTask()

        assertEquals(0, generator.lastLowerBoundary, "The lower boundary has to be 0")
        assertEquals(7, generator.lastUpperBoundary, "The upperBoundary has to be 7")
    }

}