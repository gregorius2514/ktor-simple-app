package com.codefun

import com.google.inject.AbstractModule

class DatabaseModule : AbstractModule() {
    override fun configure() {
        bind(UserRepository::class.java).to(UserRepositoryImpl::class.java)
    }
}