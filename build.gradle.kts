plugins {
    application
    kotlin("jvm") version "1.5.21"
}

group = "me.haskellv"
version = "0.0.1"
application {
    mainClass.set("me.haskellv.todo.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:1.6.2")
    implementation("io.ktor:ktor-jackson:1.6.2")
    implementation("io.ktor:ktor-freemarker:1.6.2")
    implementation("io.ktor:ktor-server-netty:1.6.2")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("org.jetbrains.exposed:exposed-core:0.31.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.31.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.31.1")
    implementation("mysql:mysql-connector-java:8.0.19")
    implementation("com.zaxxer:HikariCP:3.4.2")
    testImplementation("io.ktor:ktor-server-tests:1.6.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.5.21")
}