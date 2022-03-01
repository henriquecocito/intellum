package com.henriquecocito.intellum.entities.businessRules

internal class GetExampleLink : GetExampleLinkBusinessRule {

    private val exampleLink = "https://example.com/users"

    override fun execute(param: String): String = "$exampleLink/$param"
}