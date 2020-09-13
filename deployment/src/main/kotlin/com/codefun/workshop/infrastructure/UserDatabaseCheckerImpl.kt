package com.codefun.workshop.infrastructure

import com.codefun.UserDatabaseChecker
import com.codefun.UserRepository
import javax.inject.Inject

private const val USER_EXISTS = true

internal class UserDatabaseCheckerImpl @Inject constructor(
    private val userRepository: UserRepository
) : UserDatabaseChecker {
    override fun userExist(username: String): Boolean = userRepository.userExist(username)

    override fun userExist(username: String, password: String): Boolean =
        userRepository.findUser(username, password).let { USER_EXISTS }
}