package com.codefun

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class UserRepositoryImplTest : BehaviorSpec({

    val userRepository = UserRepositoryImpl()

    given("database contains one user") {

        `when`("query to database to find user") {
            val foundUser = userRepository.findUser("Admin", "Admin123")

            then("admin user found") {
                foundUser shouldBe User(
                        id = "1",
                        username = "Admin",
                        password = "Admin123"
                )
            }
        }
    }

})
