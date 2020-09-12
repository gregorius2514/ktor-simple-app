import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktorVersion: String by rootProject
val kotlinVersion: String by rootProject
val logbackVersion: String by rootProject
val guiceVersion: String by rootProject
val jvmVersion: String by rootProject

val kotlinTestVersion: String = "4.2.4"

plugins {
    kotlin("jvm") version "1.3.50"
}

group = "com.codefun.ktor.workshop"
version = "1.0"

allprojects {
    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        apply(plugin = "java")
        apply(plugin = "kotlin")

        implementation(kotlin("stdlib-jdk8:$kotlinVersion"))
        compile("io.ktor:ktor-server-netty:$ktorVersion")
        compile("com.google.inject:guice:$guiceVersion")
        compile("ch.qos.logback:logback-classic:$logbackVersion")

        testImplementation("io.kotest:kotest-runner-junit5:$kotlinTestVersion")
        testImplementation("io.kotest:kotest-assertions-core:$kotlinTestVersion")
        testImplementation("io.kotest:kotest-property:$kotlinTestVersion")
        testCompile("io.mockk:mockk:1.10.0")
        testCompile("org.slf4j:slf4j-simple:1.7.26")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "$jvmVersion"
}

tasks.test {
    useJUnitPlatform()
}
