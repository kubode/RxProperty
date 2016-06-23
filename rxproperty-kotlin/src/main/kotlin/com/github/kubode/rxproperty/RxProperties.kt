package com.github.kubode.rxproperty

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Overrides `value` property to provide null safety access for Kotlin.
 * @see ReadOnlyObservableProperty
 */
class ReadOnlyObservablePropertyKt<T>(delegate: Delegate<T>) : ReadOnlyObservableProperty<T>(delegate) {
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
 * @see ObservableProperty
 */
class ObservablePropertyKt<T>(state: Delegate<T>) : ObservableProperty<T>(state) {
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
 * @see ReadOnlyObservablePropertyKt
 */
fun <T> readOnlyRxProperty(delegate: ReadOnlyObservableProperty.Delegate<T>) = ReadOnlyObservablePropertyKt(delegate)

/**
 * @see ConstantKt
 */
fun <T> constant(value: T) = ConstantKt(value)

/**
 * @see ObservablePropertyKt
 */
fun <T> rxProperty(state: ObservableProperty.Delegate<T>) = ObservablePropertyKt(state)

/**
 * @see VariableKt
 */
fun <T> variable(defaultValue: T) = VariableKt(defaultValue)

/**
 * @see EmptyVariableKt
 */
fun <T> emptyVariable() = EmptyVariableKt<T>()

/**
 * Convert to [ReadOnlyProperty].
 */
fun <T> ReadOnlyObservableProperty<T>.toProperty(): ReadOnlyProperty<Any, T> {
    return object : ReadOnlyProperty<Any, T> {
        override fun getValue(thisRef: Any, property: KProperty<*>): T {
            return value
        }
    }
}

/**
 * Convert to [ReadWriteProperty].
 */
fun <T> ObservableProperty<T>.toProperty(): ReadWriteProperty<Any, T> {
    return object : ReadWriteProperty<Any, T> {
        override fun getValue(thisRef: Any, property: KProperty<*>): T {
            return value
        }

        override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
            this@toProperty.value = value
        }
    }
}
