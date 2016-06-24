package com.github.kubode.rxproperty

import org.junit.Assert.assertEquals
import org.junit.Test

class ObservablePropertiesKtTest {

    private val constant by Constant(0).toProperty()
    private var variable by Variable(0).toProperty()

    @Test fun constant() {
        assertEquals(0, constant)
    }

    @Test fun variable() {
        assertEquals(0, variable)
        variable = 1
        assertEquals(1, variable)
    }
}
