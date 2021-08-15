package me.haskellv.todo.database.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object Todos : IntIdTable("todos") {
    val title = varchar("title", 150)
    val status = bool("status")
}