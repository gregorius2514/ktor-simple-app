package com.codefun

import com.codefun.AuthenticationState.INVALID_TOKEN
import com.codefun.AuthenticationState.TOKEN_EXPIRED
import com.codefun.AuthenticationState.VALID_TOKEN

typealias AuthenticationError = IllegalStateException

interface JwtTokenAuthenticator {
    fun authenticate(token: String): Unit
}

internal class JwtTokenAuthenticatorImpl constructor(
        private val jwtTokenValidator: JwtTokenValidator
) : JwtTokenAuthenticator {
    override fun authenticate(token: String): Unit {
        when (jwtTokenValidator.validate(token)) {
            VALID_TOKEN -> Unit
            INVALID_TOKEN -> throw AuthenticationError("Unauthorized request")
            TOKEN_EXPIRED -> throw AuthenticationError("Expired token")
        }
    }
}