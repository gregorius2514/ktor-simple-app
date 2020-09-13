package com.codefun

import java.util.UUID

class UuidGenerator {
    fun generate(): String = UUID.randomUUID().toString()
}