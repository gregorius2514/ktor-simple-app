package com.codefun

import io.fusionauth.jwt.Signer
import io.fusionauth.jwt.domain.JWT
import io.fusionauth.jwt.hmac.HMACSigner
import java.time.ZoneOffset
import java.time.ZonedDateTime


class JwtTokenGenerator {

    fun generateToken(): String {
        // Build an HMAC signer using a SHA-256 hash
        // Build an HMAC signer using a SHA-256 hash
        val signer: Signer = HMACSigner.newSHA512Signer("too many secrets")

// Build a new JWT with an issuer(iss), issued at(iat), subject(sub) and expiration(exp)

// Build a new JWT with an issuer(iss), issued at(iat), subject(sub) and expiration(exp)
        val currentTime = ZonedDateTime.now(ZoneOffset.UTC)
        val jwt = JWT()
            .setIssuer("localhost")
            .setIssuedAt(currentTime)
            .setExpiration(currentTime.plusMinutes(2))
            .setSubject("f1e33ab3-027f-47c5-bb07-8dd8ab37a2d3")
            .addClaim("user", "Admin")

// Sign and encode the JWT to a JSON string representation

// Sign and encode the JWT to a JSON string representation
        val encodedJWT = JWT.getEncoder().encode(jwt, signer)
        return encodedJWT
    }
}