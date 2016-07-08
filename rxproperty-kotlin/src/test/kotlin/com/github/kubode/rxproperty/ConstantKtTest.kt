package com.github.kubode.rxproperty

import org.junit.Test

class ConstantKtTest {

    @Test(expected = NullPointerException::class) fun npeWhenJavaNullSet() {
        RxProperties.constant(Java.getNull<String>()).value.length
    }
}
