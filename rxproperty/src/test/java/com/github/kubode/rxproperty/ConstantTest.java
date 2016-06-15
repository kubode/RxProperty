package com.github.kubode.rxproperty;

import org.junit.Before;
import org.junit.Test;
import rx.functions.Action1;

import static org.junit.Assert.assertEquals;

public class ConstantTest {

    private Constant<String> val;
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
        val = new Constant<>("defaultValue");
        emittedCount = 0;
        emitted = "empty";
    }

    @Test
    public void emitDefaultValueWhenSubscribed() {
        val.subscribe(onNext);
        assertEquals("defaultValue", emitted);
        assertEquals(1, emittedCount);
    }

    @Test
    public void getDefaultValue() {
        assertEquals("defaultValue", val.getValue());
    }
}
