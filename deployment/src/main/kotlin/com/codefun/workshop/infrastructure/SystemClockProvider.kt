package com.codefun.workshop.infrastructure

import com.google.inject.Provider
import java.time.Clock
import java.time.ZoneOffset.UTC

class SystemClockProvider : Provider<Clock>{
    override fun get(): Clock = Clock.system(UTC)
}
