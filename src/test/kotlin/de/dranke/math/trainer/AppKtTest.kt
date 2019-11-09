package de.dranke.math.trainer

import kotlin.test.Test

internal class AppKtTest {

    @Test
    fun happy_path() {
        main(arrayOf("10"))
    }

    @Test
    fun missing_arguments_do_not_throw_an_exception() {
        main(arrayOf())
    }

    @Test
    fun false_arguments_do_not_throw_an_exception() {
        main(arrayOf("false"))
    }
}