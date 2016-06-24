package com.github.kubode.rxproperty

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class VariableKtTest {

    @Test fun nullable() {
        val variable = variable(null as String?)
        assertNull(variable.value)
        variable.value = ""
        assertEquals("", variable.value)
    }

    @Test(expected = Exception::class) fun failSetNullIfNotNullType() {
        variable("").value = Java.getNull()
    }
}
