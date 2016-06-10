package com.github.kubode.rxproperty;

import org.junit.Before;
import org.junit.Test;
import rx.Subscription;
import rx.functions.Action1;

import static org.junit.Assert.assertEquals;

public class VariableTest {

    private Variable<String> var;
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
        var = new Variable<>("defaultValue");
        emittedCount = 0;
        emitted = "empty";
    }

    @Test
    public void emitDefaultValueWhenSubscribed() {
        var.subscribe(onNext);
        assertEquals("defaultValue", emitted);
    }

    @Test
    public void emitHoldValueWhenSubscribed() {
        var.setValue("test");
        var.subscribe(onNext);
        assertEquals("test", emitted);
    }

    @Test
    public void emitOnceWhenSubscribed() {
        var.setValue("test");
        var.subscribe(onNext);
        assertEquals(1, emittedCount);
    }

    @Test
    public void emitSetValueWhenSubscribing() {
        var.subscribe(onNext);
        var.setValue("test");
        assertEquals("test", emitted);
    }

    @Test
    public void emitTimesPerSetWhenSubscribing() {
        var.subscribe(onNext);
        var.setValue("1");
        var.setValue("2");
        assertEquals(3, emittedCount);
    }

    @Test
    public void noEmitWhenSameValueSet() {
        var.subscribe(onNext);
        var.setValue("defaultValue");
        assertEquals(1, emittedCount);
    }

    @Test
    public void noEmitWhenNotSubscribed() {
        var.setValue("test");
        assertEquals(0, emittedCount);
    }

    @Test
    public void noEmitWhenUnsubscribed() {
        Subscription subscription = var.subscribe(onNext);
        subscription.unsubscribe();
        var.setValue("test");
        assertEquals("defaultValue", emitted);
    }

    @Test
    public void emitHoldValueWhenResubscribed() {
        Subscription subscription = var.subscribe(onNext);
        subscription.unsubscribe();
        var.setValue("test");
        var.subscribe(onNext);
        assertEquals("test", emitted);
    }
}
