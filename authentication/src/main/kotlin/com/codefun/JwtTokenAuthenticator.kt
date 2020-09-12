package com.codefun

interface JwtTokenAuthenticator {
    fun authenticate(token: String): AuthenticationState
}

internal class JwtTokenAuthenticatorImpl : JwtTokenAuthenticator {
    override fun authenticate(token: String): AuthenticationState {
        TODO("Not yet implemented")
    }
}

enum class AuthenticationState {
    VALID_TOKEN,
    INVALID_TOKEN,
    TOKEN_EXPIRED
}