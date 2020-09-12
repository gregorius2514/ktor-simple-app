package com.codefun.workshop

import com.google.inject.Inject
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

class HelloRoutes @Inject constructor(application: Application) {
    init {
        application.routing {
            get("/") {
                call.respondText {
                    "Home page"
                }
            }

            get("/hello") {
                call.respondText {
                    "Hello world"
                }
            }
        }
    }
}