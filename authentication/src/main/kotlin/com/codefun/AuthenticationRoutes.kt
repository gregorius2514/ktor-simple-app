package com.codefun

import com.google.inject.Inject
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

class AuthenticationRoutes @Inject constructor(application: Application) {
    init {
        application.routing {
            get("/auth") {
                call.respondText {
                    "Hello user"
                }
            }
        }
    }
}