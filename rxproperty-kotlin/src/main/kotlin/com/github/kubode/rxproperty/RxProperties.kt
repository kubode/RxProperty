/**
 * Classes in this module overrides `value` property to provide null safety access for Kotlin.
 */
package com.github.kubode.rxproperty

class ReadOnlyRxPropertyKt<T>(state: ReadOnlyRxProperty.State<T>) : ReadOnlyRxProperty<T>(state) {
    override fun getValue(): T = super.getValue()
}

class ConstantKt<T>(value: T) : Constant<T>(value) {
    override fun getValue(): T = super.getValue()
}

class RxPropertyKt<T>(state: RxProperty.State<T>) : RxProperty<T>(state) {
    override fun setValue(value: T) = super.setValue(value)
    override fun getValue(): T = super.getValue()
}

class VariableKt<T>(defaultValue: T) : Variable<T>(defaultValue) {
    override fun setValue(value: T) = super.setValue(value)
    override fun getValue(): T = super.getValue()
}

class EmptyVariableKt<T>() : EmptyVariable<T>() {
    override fun setValue(value: T) = super.setValue(value)
    override fun getValue(): T = super.getValue()
}

fun <T> readOnlyRxProperty(state: ReadOnlyRxProperty.State<T>) = ReadOnlyRxPropertyKt(state)
fun <T> constant(value: T) = ConstantKt(value)
fun <T> rxProperty(state: RxProperty.State<T>) = RxPropertyKt(state)
fun <T> variable(defaultValue: T) = VariableKt(defaultValue)
fun <T> emptyVariable() = EmptyVariableKt<T>()
