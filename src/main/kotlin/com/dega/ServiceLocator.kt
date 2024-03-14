package com.dega

import io.ktor.client.*
import io.ktor.client.engine.cio.*


object ServiceLocator {
    private val instances: MutableMap<Class<*>, Any> = mutableMapOf()

    init {
        instances[HttpClient::class.java] = HttpClient(CIO)
        instances[AnotherService::class.java] = AnotherServiceImpl()
        // Add more instances as needed
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> get(clazz: Class<T>): T {
        return instances[clazz] as T? ?: throw IllegalArgumentException("Instance not found for class $clazz")
    }
}

interface AnotherService {
    fun doSomething(): String
}

class AnotherServiceImpl : AnotherService {
    override fun doSomething(): String {
        return "Doing something"
    }
}
