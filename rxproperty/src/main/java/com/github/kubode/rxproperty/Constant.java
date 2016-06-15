package com.github.kubode.rxproperty;

import rx.Observable;

import javax.annotation.Nonnull;

public class Constant<T> extends ReadOnlyRxProperty<T> {

    private static class State<T> implements ReadOnlyRxProperty.State<T> {

        private final Observable<T> observable;
        private final T value;

        private State(T value) {
            this.observable = Observable.just(value);
            this.value = value;
        }

        @Nonnull
        @Override
        public Observable<T> getObservable() {
            return observable;
        }

        @Override
        public T getValue() {
            return value;
        }
    }

    public Constant(T value) {
        super(new State<>(value));
    }
}
