package com.github.kubode.rxproperty;

import org.junit.Before;
import org.junit.Test;
import rx.functions.Action1;

import static org.junit.Assert.assertEquals;

public class EmptyVariableTest {

    private EmptyVariable<String> var;
    private int emittedCount;
    private String emitted;

    private final Action1<String> onNext = new Action1<String>() {
        @Override
        public void call(String s) {
            emittedCount++;
            emitted = s;
        }
    };

    @Before
    public void setUp() {
        var = new EmptyVariable<>();
        emittedCount = 0;
        emitted = "empty";
    }

    @Test
    public void noEmitWhenSubscribed() {
        var.subscribe(onNext);
        assertEquals(0, emittedCount);
    }

    @Test
    public void emitHoldValueWhenSubscribed() {
        var.setValue("test");
        var.subscribe(onNext);
        assertEquals("test", emitted);
    }

    @Test
    public void getDefaultValueIsNullWhenNotSet() {
        assertEquals(null, var.getValue());
    }
}
