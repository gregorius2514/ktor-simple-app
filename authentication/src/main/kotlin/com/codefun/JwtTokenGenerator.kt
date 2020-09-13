package com.codefun

import com.google.inject.Inject
import io.fusionauth.jwt.Signer
import io.fusionauth.jwt.domain.JWT
import io.fusionauth.jwt.hmac.HMACSigner
import java.time.Clock
import java.time.ZonedDateTime

class JwtTokenGenerator @Inject constructor(
    private val systemClock: Clock,
    private val uuidGenerator: UuidGenerator,
    private val userDatabaseChecker: UserDatabaseChecker
) {

    fun generateToken(user: User): String {
        if (!userDatabaseChecker.userExist(user.username, user.password)) {
            throw IllegalStateException("User not found, please check username or password")
        }

        val signer: Signer =
            HMACSigner.newSHA512Signer("too many secrets") // FIXME [Szymczuch] encrypt and extract to configuration properties

        val currentTime = ZonedDateTime.now(systemClock)
        val jwt = JWT()
            .setIssuer("localhost") // FIXME [Szymczuch] extract to config file
            .setIssuedAt(currentTime)
            .setExpiration(currentTime.plusMinutes(2))
            .setSubject(uuidGenerator.generate())
            .addClaim(USER_CLAIM_NAME, user.username)

        return JWT.getEncoder().encode(jwt, signer)
    }
}