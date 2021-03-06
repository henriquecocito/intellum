package com.henriquecocito.intellum.domain.useCases

import com.henriquecocito.intellum.domain.useCases.getUsersFromText.GetUsersFromText
import com.henriquecocito.intellum.domain.useCases.getUsersFromText.GetUsersFromTextUseCase
import com.henriquecocito.intellum.entities.models.User
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetUsersFromTextUseCaseTest {

    private val getUserFromTextUseCase: GetUsersFromTextUseCase = GetUsersFromText()

    @Test
    fun whenTextIsGiven_shouldReturnASetOfUsers() {
        val expectedUsers = setOf(
            User("567", "Joe Bloggs"),
            User("123", "Henrique Cocito"),
        )

        val text = "Thanks to @[Joe Bloggs](567) and @[Henrique Cocito](123)"
        val response = getUserFromTextUseCase.execute(text)

        assertEquals(expectedUsers, response)
    }

    @Test
    fun whenTextWithNoUserTagIsGiven_shouldReturnAnEmptySet() {
        val expectedUsers = setOf<User>()

        val text = "Thanks to Joe Bloggs and Henrique Cocito"
        val response = getUserFromTextUseCase.execute(text)

        assertEquals(expectedUsers, response)
    }

    @Test
    fun whenTextWithPartOfUserTagIsGiven_shouldReturnAnEmptySet() {
        val expectedUsers = setOf<User>()

        val text = "Thanks to [Joe Bloggs](123) and @[Henrique Cocito]"
        val response = getUserFromTextUseCase.execute(text)

        assertEquals(expectedUsers, response)
    }

    @Test
    fun whenTextWithEmptyUserTagIsGiven_shouldReturnAnEmptySet() {
        val expectedUsers = setOf<User>()

        val text = "Thanks to Joe @[]() and @[]()"
        val response = getUserFromTextUseCase.execute(text)

        assertEquals(expectedUsers, response)
    }
}