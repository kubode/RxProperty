package com.github.kubode.rxproperty;

import javax.annotation.Nonnull;

public class RxProperty<T> extends ReadOnlyRxProperty<T> {

    public interface State<T> extends ReadOnlyRxProperty.State<T> {
        void setValue(T value);
    }

    private final State<T> state;

    public RxProperty(@Nonnull State<T> state) {
        super(state);
        this.state = state;
    }

    public void setValue(T value) {
        state.setValue(value);
    }
}
