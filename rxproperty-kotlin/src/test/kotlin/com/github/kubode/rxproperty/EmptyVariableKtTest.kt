package com.github.kubode.rxproperty

import org.junit.Test
import kotlin.test.assertNull

class EmptyVariableKtTest {

    @Test(expected = NullPointerException::class) fun npeWhenAccessToDefaultValue() {
        val value = emptyVariable<String>().value
        value.length
    }

    @Test fun defaultValueIsNull() {
        val value = emptyVariable<String?>().value
        assertNull(value)
    }

    @Test(expected = Exception::class) fun failSetNullIfNotNullType() {
        emptyVariable<String>().value = Java.getNull()
    }
}
