package com.codefun

import com.google.inject.Inject
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respondText
import io.ktor.routing.post
import io.ktor.routing.routing

class AuthenticationRoutes @Inject constructor(
    application: Application,
    jwtTokenGenerator: JwtTokenGenerator
) {
    init {
        application.routing {
            post("/auth") {
                // FIXME [Szymczuch] https://ktor.io/servers/features/content-negotiation.html
                //      https://ktor.io/servers/calls/requests.html#receiving
                val user = call.receive(User::class)

                call.respondText {
                    jwtTokenGenerator.generateToken()
                }
            }
        }
    }
}

data class User(
    val username: String,
    val password: String
)