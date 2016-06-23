package com.github.kubode.rxproperty;

import rx.subjects.BehaviorSubject;

/**
 * A lazy-initialize {@link Variable}.
 * <p>
 * Value is initialized not during object construction time but at {@link #setValue(Object)} called time.
 * Trying to read the property before the initial value has been assigned results <code>null</code>.
 * Trying to subscribe to the property before the initial value has been assigned emits no value.
 * </p>
 *
 * @param <T> the type of this property.
 */
public class EmptyVariable<T> extends ObservableProperty<T> {

    /**
     * Creates an EmptyVariable.
     */
    public EmptyVariable() {
        super(new Variable.State<>(BehaviorSubject.<T>create()));
    }
}
