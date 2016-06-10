package com.github.kubode.rxproperty;

import rx.subjects.BehaviorSubject;

public class EmptyVariable<T> extends RxProperty<T> {

    private static class State<T> extends Variable.State<T> {

        private State() {
            super(BehaviorSubject.<T>create());
        }
    }

    public EmptyVariable() {
        super(new State<T>());
    }
}
