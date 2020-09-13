package com.codefun

import com.codefun.AuthenticationState.*
import com.google.inject.Inject
import io.fusionauth.jwt.Verifier
import io.fusionauth.jwt.domain.JWT
import io.fusionauth.jwt.hmac.HMACVerifier

const val USER_CLAIM_NAME = "user"

internal class JwtTokenValidator @Inject constructor(
        private val userDatabaseChecker: UserDatabaseChecker
) {
    fun validate(token: String): AuthenticationState {
        val tokenVerifier: Verifier = HMACVerifier.newVerifier("too many secrets") // FIXME [Szymczuch] encrypt and extract to configuration properties
        val decodedJwtToken: JWT = JWT.getDecoder().decode(token, tokenVerifier)

        val username = decodedJwtToken.otherClaims[USER_CLAIM_NAME] as String
        return if (userDatabaseChecker.userExist(username)) {
            if (!decodedJwtToken.isExpired) {
                VALID_TOKEN
            } else {
                TOKEN_EXPIRED
            }
        } else {
            INVALID_TOKEN
        }
    }
}

enum class AuthenticationState {
    VALID_TOKEN,
    INVALID_TOKEN,
    TOKEN_EXPIRED
}
