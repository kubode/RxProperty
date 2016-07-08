package com.github.kubode.rxproperty

import org.junit.Test
import kotlin.test.assertEquals

class EmptyVariableKtTest {

    @Test(expected = NullPointerException::class) fun npeWhenAccessToDefaultValue() {
        val value = RxProperties.emptyVariable<String>().value
        value.length
    }

    @Test fun setAndGet() {
        val variable = RxProperties.emptyVariable<String>()
        variable.value = ""
        assertEquals("", variable.value)
    }

    @Test(expected = Exception::class) fun failSetNullIfNotNullType() {
        RxProperties.emptyVariable<String>().value = Java.getNull()
    }
}
