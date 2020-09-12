package com.codefun.workshop

import com.codefun.AuthenticationModule
import com.codefun.DatabaseModule
import com.google.inject.AbstractModule
import io.ktor.application.*

class MainModule(private val application: Application) : AbstractModule() {
    override fun configure() {
        install(DatabaseModule())
        install(AuthenticationModule())
        bind(Application::class.java).toInstance(application)
    }
}