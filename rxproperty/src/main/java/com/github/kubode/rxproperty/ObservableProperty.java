package com.github.kubode.rxproperty;

import rx.Observable;
import rx.Observer;

import javax.annotation.Nonnull;

/**
 * {@link Observable} that emits the most recent item it has observed and all subsequent observed items to each
 * subscribed {@link Observer}.
 *
 * @param <T> the type of this property.
 */
public class ObservableProperty<T> extends ReadOnlyObservableProperty<T> {

    /**
     * The state of {@link ObservableProperty}.
     * Generally, {@link #getObservable()} should emit the most recent value when subscribed.
     *
     * @param <T> the type of value property and item expected to be observed by the {@link #getObservable()}.
     */
    public interface State<T> extends ReadOnlyObservableProperty.State<T> {

        /**
         * Sets the value of this state and emits the value to each {@link Observer} subscribed to
         * {@link #getObservable()} if modified.
         *
         * @param value a value set to this state.
         */
        void setValue(T value);
    }

    private final State<T> state;

    /**
     * Creates an ObservableProperty.
     *
     * @param state a state of this property.
     */
    public ObservableProperty(@Nonnull State<T> state) {
        super(state);
        this.state = state;
    }

    /**
     * Sets the value of this property and emits the value to each subscribed {@link Observer} if modified.
     *
     * @param value a value set to this property.
     */
    public void setValue(T value) {
        state.setValue(value);
    }
}
