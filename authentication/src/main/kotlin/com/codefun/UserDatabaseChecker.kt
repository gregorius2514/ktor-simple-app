package com.codefun

interface UserDatabaseChecker {
    fun userExist(username: String): Boolean
    fun userExist(username: String, password: String): Boolean
}