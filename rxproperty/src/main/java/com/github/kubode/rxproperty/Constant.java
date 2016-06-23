package com.github.kubode.rxproperty;

import rx.Observable;

import javax.annotation.Nonnull;

/**
 * A constant {@link ReadOnlyObservableProperty}.
 * <p>
 * This behave like a {@link Observable#just(Object)}.
 * {@link #getValue()} returns the same value always.
 * </p>
 *
 * @param <T> the type of this property.
 */
public class Constant<T> extends ReadOnlyObservableProperty<T> {

    private static class State<T> implements ReadOnlyObservableProperty.State<T> {

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

    /**
     * Creates a constant {@link ReadOnlyObservableProperty}.
     *
     * @param value value of this property.
     */
    public Constant(T value) {
        super(new State<>(value));
    }
}
