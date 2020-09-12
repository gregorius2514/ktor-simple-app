package com.codefun

import com.google.inject.Binder
import com.google.inject.Module

class DatabaseModule : Module {
    override fun configure(binder: Binder) {
        binder.bind(UserRepository::class.java).to(UserRepositoryImpl::class.java)
    }
}