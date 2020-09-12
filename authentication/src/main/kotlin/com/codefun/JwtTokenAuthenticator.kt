package com.codefun

interface JwtTokenAuthenticator {
    fun authenticate(token: String): AuthenticatedState
}

internal class JwtTokenAuthenticatorImpl : JwtTokenAuthenticator {
    override fun authenticate(token: String): AuthenticatedState {
        TODO("Not yet implemented")
    }
}

enum class AuthenticatedState {
    VALID_TOKEN,
    INVALID_TOKEN,
    TOKEN_EXPIRED
}