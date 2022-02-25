package com.henriquecocito.intellum.useCases

import com.henriquecocito.intellum.domain.useCases.GetUserFromText
import com.henriquecocito.intellum.domain.useCases.GetUserFromTextUseCase
import com.henriquecocito.intellum.entities.User
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetUserFromTextUseCaseTest {

    private val getUserFromTextUseCase: GetUserFromTextUseCase = GetUserFromText()

    @Test
    fun shouldReturnAListOfUsers_whenTextIsGiven() {
        val expectedUsers = setOf(
            User("567", "Joe Bloggs"),
            User("123", "Henrique Cocito"),
        )

        val text = "Thanks to @[Joe Bloggs](567) and @[Henrique Cocito](123)"
        val response = getUserFromTextUseCase.execute(text)

        assertEquals(response, expectedUsers)
    }
}