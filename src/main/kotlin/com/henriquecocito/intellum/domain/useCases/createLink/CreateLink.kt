package com.henriquecocito.intellum.domain.useCases.createLink

import com.henriquecocito.intellum.entities.businessRules.GetExampleLinkBusinessRule

internal class CreateLink(
    private val exampleLinkBusinessRule: GetExampleLinkBusinessRule
) : CreateLinkUseCase {

    override fun execute(param: CreateLinkParam): String {
        val regex = "@\\[(${param.user.name})\\]\\((${param.user.id})\\)".toRegex()
        val link = exampleLinkBusinessRule.execute(param.user.id)

        return regex.replace(param.text, "[@${param.user.name}]($link)")
    }
}