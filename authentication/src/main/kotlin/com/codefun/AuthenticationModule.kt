package com.codefun

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.inject.Binder
import com.google.inject.Module

class AuthenticationModule : Module {
    override fun configure(binder: Binder) {
        binder.bind(JwtTokenAuthenticator::class.java).to(JwtTokenAuthenticatorImpl::class.java).asEagerSingleton()
        binder.bind(AuthenticationRoutes::class.java).asEagerSingleton()
        binder.bind(UuidGenerator::class.java)
        binder.bind(ObjectMapper::class.java).annotatedWith(AuthenticationAnnotation::class.java).toProvider(ObjectMapperProvider::class.java)
    }
}

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation class AuthenticationAnnotation 