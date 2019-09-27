package com.virtuslab.workshop

import com.google.inject.Binder
import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Module
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    Guice.createInjector(MainModule())
}

class MainModule : Module {

    override fun configure(binder: Binder) {
        binder.bind(AppRunner::class.java).asEagerSingleton()
    }
}

class AppRunner @Inject constructor() {
    init {
        embeddedServer(Netty, 8080)
        {
            routing {
                get("/") {
                    call.respondText("Hello Kielce", ContentType.Text.Html)
                }
            }
        }.start(wait = true)
    }
}
