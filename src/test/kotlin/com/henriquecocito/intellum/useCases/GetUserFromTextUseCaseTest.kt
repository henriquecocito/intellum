package com.henriquecocito.intellum.useCases

import com.henriquecocito.intellum.domain.useCases.GetUsersFromText
import com.henriquecocito.intellum.domain.useCases.GetUsersFromTextUseCase
import com.henriquecocito.intellum.entities.User
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetUserFromTextUseCaseTest {

    private val getUserFromTextUseCase: GetUsersFromTextUseCase = GetUsersFromText()

    @Test
    fun shouldReturnASetOfUsers_whenTextIsGiven() {
        val expectedUsers = setOf(
            User("567", "Joe Bloggs"),
            User("123", "Henrique Cocito"),
        )

        val text = "Thanks to @[Joe Bloggs](567) and @[Henrique Cocito](123)"
        val response = getUserFromTextUseCase.execute(text)

        assertEquals(response, expectedUsers)
    }

    @Test
    fun shouldReturnAnEmptySet_whenTextWithNoUserTagIsGiven() {
        val expectedUsers = setOf<User>()

        val text = "Thanks to Joe Bloggs and Henrique Cocito"
        val response = getUserFromTextUseCase.execute(text)

        assertEquals(response, expectedUsers)
    }

    @Test
    fun shouldReturnAnEmptySet_whenTextWithPartOfUserTagIsGiven() {
        val expectedUsers = setOf<User>()

        val text = "Thanks to [Joe Bloggs](123) and @[Henrique Cocito]"
        val response = getUserFromTextUseCase.execute(text)

        assertEquals(response, expectedUsers)
    }

    @Test
    fun shouldReturnAnEmptySet_whenTextWithEmptyUserTagIsGiven() {
        val expectedUsers = setOf<User>()

        val text = "Thanks to Joe @[]() and @[]()"
        val response = getUserFromTextUseCase.execute(text)

        assertEquals(response, expectedUsers)
    }
}