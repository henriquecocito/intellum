package com.henriquecocito.intellum.entities.businessRules

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetExampleLinkBusinessRuleTest {

    private val getExampleLink: GetExampleLink = GetExampleLink()

    @Test
    fun givenUserId_shouldReturnExampleLink() {
        val expectedResult = "https://example.com/users/123"
        val result = getExampleLink.execute("123")

        assertEquals(expectedResult, result)
    }

    @Test
    fun givenEmptyUserId_shouldReturnExampleLinkWithoutUserId() {
        val expectedResult = "https://example.com/users/"
        val result = getExampleLink.execute("")

        assertEquals(expectedResult, result)
    }
}