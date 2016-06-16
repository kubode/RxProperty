package com.github.kubode.rxproperty

import org.junit.Test

class EmptyVariableKtTest {

    @Test(expected = NullPointerException::class)
    fun npeOnGetValueWhenNoValueEmitted() {
        val value = emptyVariable<String>().value
        value.length
    }
}
