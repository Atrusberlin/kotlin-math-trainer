package de.dranke.math.trainer.tasks

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class AdditionTaskFactoryTest {

    private lateinit var task: AdditionTaskFactory.Task

    @BeforeTest
    fun setup() {
        task = AdditionTaskFactory().createTask()
    }

    @Test
    fun the_task_operation_is_plus() {
        assertEquals('+', task.operation, "Operation has to be '+'")
    }

    @Test
    fun the_first_addent_is_1() {
        assertEquals(1, task.addend1, "First addent has to be 1")
    }

    @Test
    fun the_second_addent_is_2() {
        assertEquals(2, task.addend2, "Second addent has to be 2")
    }
}