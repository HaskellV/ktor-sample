package me.haskellv.todo.plugins

import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import me.haskellv.todo.database.entities.Todo
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureRouting() {

    routing {
        get("/") {
            val todos = transaction {
                Todo.all().toList()
            }

            call.respond(FreeMarkerContent("home.ftl", mapOf("todos" to todos)))
        }

        get("/dodaj") {
            call.respond(FreeMarkerContent("add.ftl", emptyMap<Any, Any>()))
        }

        post("/dodaj") {
            val formData = call.receiveParameters()

            transaction {
                Todo.new {
                    title = formData["title"].toString()
                    status = false
                }
            }

            call.respondRedirect("/")
        }

        get("/ukonczono") {
            val id = call.request.queryParameters["id"]?.toInt()

            if (id == null) {
                call.respondRedirect("/")
                return@get
            }

            transaction {
                Todo.findById(id)?.status = true
            }

            call.respondRedirect("/")
        }

        get("usun") {
            val id = call.request.queryParameters["id"]?.toInt()

            if (id == null) {
                call.respondRedirect("/")
                return@get
            }

            transaction {
                Todo.findById(id)?.delete()
            }

            call.respondRedirect("/")
        }
    }
}
