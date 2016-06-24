package com.github.kubode.rxproperty

import org.junit.Assert.assertEquals
import org.junit.Test
import rx.Observable

class ReadOnlyObservablePropertyKtTest {

    @Test fun test() {
        val p = readOnlyObservableProperty(object : ReadOnlyObservableProperty.State<Int> {
            override fun getObservable() = Observable.just(1)
            override fun getValue() = 2
        })
        assertEquals(1, p.toBlocking().first())
        assertEquals(2, p.value)
    }
}
