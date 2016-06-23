package com.github.kubode.rxproperty;

import rx.Observable;
import rx.Observer;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

import javax.annotation.Nonnull;

/**
 * {@link ObservableProperty} that emits the most recent item it has observed and all subsequent observed items to each
 * subscribed {@link Observer}.
 *
 * @param <T> the type of this property.
 */
public class Variable<T> extends ObservableProperty<T> {

    /**
     * The state of {@link Variable}.
     * Thread-safe and not emit item until changed.
     *
     * @param <T> the type of value property and item expected to be observed by the {@link #getObservable()}.
     */
    static class State<T> implements ObservableProperty.State<T> {

        private final BehaviorSubject<T> behaviorSubject;
        private final SerializedSubject<T, T> serializedSubject;

        private State(T defaultValue) {
            this(BehaviorSubject.create(defaultValue));
        }

        /**
         * Visible for EmptyVariable.
         */
        State(@Nonnull BehaviorSubject<T> behaviorSubject) {
            this.behaviorSubject = behaviorSubject;
            this.serializedSubject = behaviorSubject.toSerialized();
        }

        @Nonnull
        @Override
        public Observable<T> getObservable() {
            return serializedSubject.distinctUntilChanged();
        }

        @Override
        public T getValue() {
            return behaviorSubject.getValue();
        }

        @Override
        public void setValue(T value) {
            serializedSubject.onNext(value);
        }
    }

    /**
     * Creates a Variable.
     *
     * @param defaultValue an initial value of this property.
     */
    public Variable(T defaultValue) {
        super(new State<>(defaultValue));
    }
}
