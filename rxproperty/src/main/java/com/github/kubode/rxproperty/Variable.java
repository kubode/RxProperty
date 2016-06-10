package com.github.kubode.rxproperty;

import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

import javax.annotation.Nonnull;

public class Variable<T> extends RxProperty<T> {

    static class State<T> implements RxProperty.State<T> {
        private final BehaviorSubject<T> behaviorSubject;
        private final SerializedSubject<T, T> serializedSubject;

        private State(T defaultValue) {
            this(BehaviorSubject.create(defaultValue));
        }

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

    public Variable(T defaultValue) {
        super(new State<>(defaultValue));
    }
}
