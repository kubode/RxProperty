package com.github.kubode.rxproperty

import org.junit.Assert.assertEquals
import org.junit.Test
import rx.subjects.BehaviorSubject

class ObservablePropertyKtTest {

    @Test fun test() {
        val p = observableProperty(Variable.State(BehaviorSubject.create(0)))
        assertEquals(0, p.value)
        p.value = 1
        assertEquals(1, p.toBlocking().first())
    }
}
