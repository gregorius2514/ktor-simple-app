package com.codefun

import io.ktor.features.NotFoundException
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

interface UserRepository {
    fun findUser(username: String, password: String): User
}

typealias UserNotFound = NotFoundException
typealias InvalidUserPassword = IllegalStateException

internal class UserRepositoryImpl : UserRepository {
    companion object {
        private val inMemoryDatabase: ConcurrentMap<String, User> = ConcurrentHashMap()
    }

    init {
        inMemoryDatabase["Admin"] = User(
                id = "1",
                username = "Admin",
                password = "Admin123"
        )
    }

    override fun findUser(username: String, password: String): User {
        if (!inMemoryDatabase.containsKey(username)) {
            throw UserNotFound("User not found, username: [$username]")
        }

        val user = inMemoryDatabase[username]!!
        if (!user.checkPassword(password)) {
            throw InvalidUserPassword("Invalid username password, username: [$username]")
        }
        return user
    }
}

data class User(
        private val id: String,
        val username: String,
        private val password: String
) {
    fun checkPassword(passwordToCheck: String): Boolean = password == passwordToCheck
}