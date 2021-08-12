package me.haskellv.plugins

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.*
import me.haskellv.database.tables.Todos
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabase(){
    val config = HikariConfig().apply {
        jdbcUrl         = "jdbc:mysql://localhost/ktor"
        driverClassName = "com.mysql.cj.jdbc.Driver"
        username        = "root"
        password        = "root"
        maximumPoolSize = 10
    }
    val dataSource = HikariDataSource(config)
    Database.connect(dataSource)

    transaction {
        SchemaUtils.create(Todos)
    }
}

fun seedDatabase() {

}