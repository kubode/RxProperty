package com.github.kubode.rxproperty

import org.junit.Test

class ConstantKtTest {

    @Test(expected = NullPointerException::class) fun npeWhenJavaNullSet() {
        constant(Java.getNull<String>()).value.length
    }
}
