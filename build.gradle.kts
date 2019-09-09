import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version = "1.2.4"


plugins {
    kotlin("jvm") version "1.3.50"
}

group = "com.virtuslab.ktor.workshop"
version = "1.0"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compile("io.ktor:ktor-server-netty:$ktor_version")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}