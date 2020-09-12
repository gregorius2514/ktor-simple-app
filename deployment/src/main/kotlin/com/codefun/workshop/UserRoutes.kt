package com.codefun.workshop

import com.google.inject.Inject
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

class UserRoutes @Inject constructor(application: Application) {
    init {
        application.routing {
            get("/user/hello") {
                call.respondText {
                    "Hello user"
                }
            }

            get("/user/logout") {
                call.respondText {
                    "logout"
                }
            }
        }
    }
}