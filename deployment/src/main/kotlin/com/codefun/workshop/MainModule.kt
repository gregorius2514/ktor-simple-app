package com.codefun.workshop

import com.codefun.AuthenticationModule
import com.codefun.DatabaseModule
import com.codefun.UserDatabaseChecker
import com.codefun.workshop.infrastructure.SystemClockProvider
import com.codefun.workshop.infrastructure.UserDatabaseCheckerImpl
import com.google.inject.AbstractModule
import io.ktor.application.Application
import java.time.Clock

class MainModule(private val application: Application) : AbstractModule() {
    override fun configure() {
        install(DatabaseModule())
        install(AuthenticationModule())
        bind(Application::class.java).toInstance(application)
        bind(UserDatabaseChecker::class.java).to(UserDatabaseCheckerImpl::class.java)
        bind(Clock::class.java).toProvider(SystemClockProvider::class.java)
    }
}