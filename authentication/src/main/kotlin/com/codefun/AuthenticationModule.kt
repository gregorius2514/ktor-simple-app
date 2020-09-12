package com.codefun

import com.google.inject.Binder
import com.google.inject.Module

class AuthenticationModule : Module {
    override fun configure(binder: Binder) {
        binder.bind(JwtTokenAuthenticator::class.java).to(JwtTokenAuthenticatorImpl::class.java).asEagerSingleton()
        binder.bind(AuthenticationRoutes::class.java).asEagerSingleton()
    }
}