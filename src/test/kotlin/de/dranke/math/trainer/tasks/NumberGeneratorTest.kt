package de.dranke.math.trainer.tasks

import kotlin.test.Test
import kotlin.test.assertEquals

internal class NumberGeneratorTest {

    private val generator = NumberGenerator()

    @Test
    fun if_lowerBoundary_equals_upperBoundary_retrun_0() {
        val next = generator.next(2, 2)

        assertEquals(0, next)
    }

    @Test
    fun if_lowerBoundary_greater_uperBoundary_return_0() {
        val next = generator.next(2, 1)

        assertEquals(0, next)
    }
}