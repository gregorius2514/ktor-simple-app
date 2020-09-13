package com.codefun

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.inject.Inject
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

class AuthenticationRoutes @Inject constructor(
    application: Application,
    private val jwtTokenGenerator: JwtTokenGenerator,
    @AuthenticationAnnotation private val objectMapper: ObjectMapper

) {
    init {
        application.routing {
            post("/auth") {
                // FIXME [Szymczuch] https://ktor.io/servers/features/content-negotiation.html
                //      https://ktor.io/servers/calls/requests.html#receiving
                val user = call.receive(String::class).let { objectMapper.readValue(it, User::class.java) }

                call.respondText {
                    jwtTokenGenerator.generateToken(user)
                }
            }
        }
    }
}
