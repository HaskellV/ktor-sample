package me.haskellv.plugins

import freemarker.cache.*
import io.ktor.freemarker.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

fun Application.configureTemplating() {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }
}