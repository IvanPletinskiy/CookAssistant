package com.handen.cookassistant.di

import kotlin.reflect.KClass

object ServiceLocator {
    @PublishedApi
    internal val dependencies: MutableMap<KClass<out Any>, Lazy<Any>> = mutableMapOf()

    init {

    }

    inline fun <reified T : Any> resolve(): T {
        return if (dependencies.containsKey(T::class)) {
            (dependencies[T::class])!!.value as T
        } else {
            throw DependencyUnregisteredException(T::class)
        }
    }

    class DependencyUnregisteredException(private val kClass: KClass<out Any>) : Exception() {
        override val message: String?
            get() = "Cannot resolve dependency:$kClass. It is not registered."
    }
}