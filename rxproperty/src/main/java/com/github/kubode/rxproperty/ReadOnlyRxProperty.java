package com.github.kubode.rxproperty;

import rx.Observable;
import rx.Subscriber;

import javax.annotation.Nonnull;

public class ReadOnlyRxProperty<T> extends Observable<T> {

    public interface State<T> {

        @Nonnull
        Observable<T> getObservable();

        T getValue();
    }

    private final State<T> state;

    public ReadOnlyRxProperty(@Nonnull final State<T> state) {
        super(new OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                subscriber.add(state.getObservable().subscribe(subscriber));
            }
        });
        this.state = state;
    }

    public T getValue() {
        return state.getValue();
    }
}
