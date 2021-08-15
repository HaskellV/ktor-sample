package me.haskellv

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import me.haskellv.todo.plugins.configureDatabase
import me.haskellv.todo.plugins.configureRouting
import me.haskellv.todo.plugins.configureTemplating

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureDatabase()
        configureRouting()
        configureTemplating()
    }.start(wait = true)
}
