package com.github.kubode.rxproperty;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Read-only Observable property.
 *
 * @param <T> the type of this property.
 */
public class ReadOnlyObservableProperty<T> extends Observable<T> {

    /**
     * The state of {@link ReadOnlyObservableProperty}.
     * Generally, {@link #getObservable()} should emit the most recent value when subscribed.
     *
     * @param <T> the type of value property and item expected to be observed by the {@link #getObservable()}.
     */
    public interface State<T> {

        /**
         * Returns {@link Observable} of this state.
         *
         * @return an {@link Observable} that emits the most recent value it has observed
         * and all subsequent observed items to each subscribed {@link Observer}.
         */
        Observable<T> getObservable();

        /**
         * Returns value of this state.
         *
         * @return a value of this state.
         */
        T getValue();
    }

    private final State<T> state;

    /**
     * Creates a ReadOnlyObservableProperty.
     *
     * @param state a state of this property.
     */
    public ReadOnlyObservableProperty(final State<T> state) {
        super(new OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                subscriber.add(state.getObservable().subscribe(subscriber));
            }
        });
        this.state = state;
    }

    /**
     * Get value of this property.
     *
     * @return value of this property.
     */
    public T getValue() {
        return state.getValue();
    }
}
