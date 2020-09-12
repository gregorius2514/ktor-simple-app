package com.codefun.workshop

import com.google.inject.Binder
import com.google.inject.Module

class AppRoutes : Module {

    override fun configure(binder: Binder) {
        binder.bind(HelloRoutes::class.java).asEagerSingleton()
        binder.bind(UserRoutes::class.java).asEagerSingleton()
    }
}

