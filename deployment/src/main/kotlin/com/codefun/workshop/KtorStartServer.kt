package com.codefun.workshop

import com.codefun.DatabaseModule
import com.google.inject.AbstractModule
import com.google.inject.Guice
import io.ktor.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    embeddedServer(Netty, commandLineEnvironment(args)).start()
}

fun Application.module() {
    Guice.createInjector(MainModule(this), AppRoutes())
}

class MainModule(private val application: Application) : AbstractModule() {
    override fun configure() {
        install(DatabaseModule())
        bind(Application::class.java).toInstance(application)
    }
}
