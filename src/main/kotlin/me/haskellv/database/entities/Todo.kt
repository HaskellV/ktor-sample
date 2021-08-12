package me.haskellv.database.entities

import me.haskellv.database.tables.Todos
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Todo(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<Todo>(Todos)
    var title by Todos.title
    var status by Todos.status
}