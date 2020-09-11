import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktorVersion: String by rootProject
val kotlinVersion: String by rootProject
val logbackVersion: String by rootProject
val guiceVersion: String by rootProject
val jvmVersion: String by rootProject


plugins {
    kotlin("jvm") version "1.3.50"
}

group = "com.virtuslab.ktor.workshop"
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
    }

}
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "$jvmVersion"
    }
