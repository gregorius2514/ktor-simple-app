package com.codefun.workshop

import com.google.inject.AbstractModule
import com.google.inject.Inject
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing

class AppRoutes : AbstractModule() {
    override fun configure() {
        bind(HelloRoutes::class.java).asEagerSingleton()
        bind(UserRoutes::class.java).asEagerSingleton()
    }
}

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

