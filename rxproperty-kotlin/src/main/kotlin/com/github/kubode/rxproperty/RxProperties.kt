package com.github.kubode.rxproperty

/**
 * Overrides `value` property to provide null safety access for Kotlin.
 * @see ReadOnlyRxProperty
 */
class ReadOnlyRxPropertyKt<T>(state: ReadOnlyRxProperty.State<T>) : ReadOnlyRxProperty<T>(state) {
    override fun getValue(): T = super.getValue()
}

/**
 * Overrides `value` property to provide null safety access for Kotlin.
 * @see Constant
 */
class ConstantKt<T>(value: T) : Constant<T>(value) {
    override fun getValue(): T = super.getValue()
}

/**
 * Overrides `value` property to provide null safety access for Kotlin.
 * @see RxProperty
 */
class RxPropertyKt<T>(state: RxProperty.State<T>) : RxProperty<T>(state) {
    override fun setValue(value: T) = super.setValue(value)
    override fun getValue(): T = super.getValue()
}

/**
 * Overrides `value` property to provide null safety access for Kotlin.
 * @see Variable
 */
class VariableKt<T>(defaultValue: T) : Variable<T>(defaultValue) {
    override fun setValue(value: T) = super.setValue(value)
    override fun getValue(): T = super.getValue()
}

/**
 * Overrides `value` property to provide null safety access for Kotlin.
 * @see EmptyVariable
 */
class EmptyVariableKt<T>() : EmptyVariable<T>() {
    override fun setValue(value: T) = super.setValue(value)
    override fun getValue(): T = super.getValue()
}

/**
 * @see ReadOnlyRxPropertyKt
 */
fun <T> readOnlyRxProperty(state: ReadOnlyRxProperty.State<T>) = ReadOnlyRxPropertyKt(state)

/**
 * @see ConstantKt
 */
fun <T> constant(value: T) = ConstantKt(value)

/**
 * @see RxPropertyKt
 */
fun <T> rxProperty(state: RxProperty.State<T>) = RxPropertyKt(state)

/**
 * @see VariableKt
 */
fun <T> variable(defaultValue: T) = VariableKt(defaultValue)

/**
 * @see EmptyVariableKt
 */
fun <T> emptyVariable() = EmptyVariableKt<T>()
