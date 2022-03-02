package com.henriquecocito.intellum.presentation

import com.henriquecocito.intellum.domain.useCases.createLink.CreateLinkUseCase
import com.henriquecocito.intellum.domain.useCases.getUsersFromText.GetUsersFromTextUseCase
import com.henriquecocito.intellum.entities.models.User
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IntellumPresenterTest {

    private val getUsersFromTextUseCase: GetUsersFromTextUseCase = mockk()
    private val createLinkUseCase: CreateLinkUseCase = mockk()

    private val presenter: IntellumPresenter = IntellumPresenter(getUsersFromTextUseCase, createLinkUseCase)

    @Test
    fun givenUsers_whenTextIsGiven_shouldReturnLinksConvertedToMarkdown() {
        val input = "Thanks to @[Joe Bloggs](567) and @[Henrique Cocito](123)"

        val stubbedUsers = setOf(
            User("567", "Joe Bloggs"),
            User("123", "Henrique Cocito"),
        )
        every { getUsersFromTextUseCase.execute(any()) } returns stubbedUsers

        every {
            createLinkUseCase.execute(any())
        } returns "Thanks to [@Joe Bloggs](http://localhost/567) and @[Henrique Cocito](123)" andThen "Thanks to [@Joe Bloggs](http://localhost/567) and [@Henrique Cocito](http://localhost/123)"

        val expectedResponse =
            "Thanks to [@Joe Bloggs](http://localhost/567) and [@Henrique Cocito](http://localhost/123)"

        val response = presenter.textToMarkdown(input)

        verify(exactly = 2) { createLinkUseCase.execute(any()) }
        assertEquals(expectedResponse, response)
    }

    @Test
    fun givenEmptyUsers_whenTextIsGiven_shouldReturnLinksConvertedToMarkdown() {
        val input = "Thanks to @[Joe Bloggs](567) and @[Henrique Cocito](123)"

        val stubbedUsers = setOf<User>()
        every { getUsersFromTextUseCase.execute(any()) } returns stubbedUsers

        val expectedResponse = "Thanks to @[Joe Bloggs](567) and @[Henrique Cocito](123)"

        val response = presenter.textToMarkdown(input)

        verify(inverse = true) { createLinkUseCase.execute(any()) }
        assertEquals(expectedResponse, response)
    }

    @Test
    fun whenEmptyTextIsGiven_shouldReturnLinksConvertedToMarkdown() {
        val input = ""
        val expectedResponse = ""

        val response = presenter.textToMarkdown(input)

        verify(inverse = true) { getUsersFromTextUseCase.execute(any()) }
        verify(inverse = true) { createLinkUseCase.execute(any()) }
        assertEquals(expectedResponse, response)
    }
}