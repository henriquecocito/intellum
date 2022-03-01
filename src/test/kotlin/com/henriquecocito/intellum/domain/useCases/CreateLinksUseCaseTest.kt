package com.henriquecocito.intellum.domain.useCases

import com.henriquecocito.intellum.domain.useCases.createLink.CreateLink
import com.henriquecocito.intellum.domain.useCases.createLink.CreateLinkUseCase
import com.henriquecocito.intellum.domain.useCases.createLink.CreateLinkParam
import com.henriquecocito.intellum.entities.businessRules.GetExampleLinkBusinessRule
import com.henriquecocito.intellum.entities.models.User
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

class CreateLinksUseCaseTest {

    private val businessRule: GetExampleLinkBusinessRule = mockk()

    private val createLinkUseCase: CreateLinkUseCase = CreateLink(businessRule)

    @Test
    fun givenExampleLink_whenTextAndUserAreGiven_shouldReturnTheTextWithMarkdownLink() {
        val stubbedLink = "http://localhost/123"
        val expectedResponse = "Thanks to @[Joe Bloggs](567) and [@Henrique Cocito](http://localhost/123)"

        every { businessRule.execute(any()) } returns stubbedLink

        val response = createLinkUseCase.execute(
            CreateLinkParam(
                "Thanks to @[Joe Bloggs](567) and @[Henrique Cocito](123)",
                User("123", "Henrique Cocito")
            )
        )

        assertEquals(expectedResponse, response)
    }

    @Test
    fun givenExampleLink_whenTextWithNoUserTagIsGiven_shouldReturnTheSameText() {
        val stubbedLink = "http://localhost/123"
        val expectedResponse = "Thanks to Joe Bloggs and Henrique Cocito"

        every { businessRule.execute(any()) } returns stubbedLink

        val response = createLinkUseCase.execute(
            CreateLinkParam(
                "Thanks to Joe Bloggs and Henrique Cocito",
                User("123", "Henrique Cocito")
            )
        )

        assertEquals(expectedResponse, response)
    }

    @Test
    fun givenExampleLink_whenTextWithPartOfUserTagIsGiven_shouldReturnTheSameText() {
        val stubbedLink = "http://localhost/123"
        val expectedResponse = "Thanks to [Joe Bloggs](123) and @[Henrique Cocito]"

        every { businessRule.execute(any()) } returns stubbedLink

        val response = createLinkUseCase.execute(
            CreateLinkParam(
                "Thanks to [Joe Bloggs](123) and @[Henrique Cocito]",
                User("123", "Henrique Cocito")
            )
        )

        assertEquals(expectedResponse, response)
    }
}