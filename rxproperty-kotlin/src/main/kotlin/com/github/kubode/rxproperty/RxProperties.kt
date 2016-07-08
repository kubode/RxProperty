package com.github.kubode.rxproperty

/**
 * RxProperty factory object.
 */
object RxProperties {

    /**
     * @see ReadOnlyObservableProperty
     */
    fun <T> readOnlyObservable(state: ReadOnlyObservableProperty.State<T>) = readOnlyObservableProperty(state)

    /**
     * @see ObservableProperty
     */
    fun <T> observable(state: ObservableProperty.State<T>) = observableProperty(state)

    /**
     * @see Constant
     */
    fun <T> constant(value: T) = com.github.kubode.rxproperty.constant(value)

    /**
     * @see Variable
     */
    fun <T> variable(value: T) = com.github.kubode.rxproperty.variable(value)

    /**
     * @see EmptyVariable
     */
    fun <T> emptyVariable() = com.github.kubode.rxproperty.emptyVariable<T>()
}
