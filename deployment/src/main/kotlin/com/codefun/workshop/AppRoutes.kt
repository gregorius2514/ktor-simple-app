package com.codefun.workshop

import com.google.inject.AbstractModule

class AppRoutes : AbstractModule() {
    override fun configure() {
        bind(HelloRoutes::class.java).asEagerSingleton()
        bind(UserRoutes::class.java).asEagerSingleton()
    }
}

