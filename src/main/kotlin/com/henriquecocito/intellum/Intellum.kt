package com.henriquecocito.intellum

import com.henriquecocito.intellum.domain.useCases.createLink.CreateLink
import com.henriquecocito.intellum.domain.useCases.createLink.CreateLinkUseCase
import com.henriquecocito.intellum.domain.useCases.getUsersFromText.GetUsersFromText
import com.henriquecocito.intellum.domain.useCases.getUsersFromText.GetUsersFromTextUseCase
import com.henriquecocito.intellum.entities.businessRules.GetExampleLink
import com.henriquecocito.intellum.entities.businessRules.GetExampleLinkBusinessRule
import com.henriquecocito.intellum.presentation.IntellumPresenter

object Intellum {

    private val getExampleLinkBusinessRule: GetExampleLinkBusinessRule by lazy { GetExampleLink() }
    private val createLinkUseCase: CreateLinkUseCase by lazy { CreateLink(getExampleLinkBusinessRule) }
    private val getUsersFromTextUseCase: GetUsersFromTextUseCase by lazy { GetUsersFromText() }

    private val presenter: IntellumPresenter = IntellumPresenter(getUsersFromTextUseCase, createLinkUseCase)

    @JvmStatic
    fun main(args: Array<String>) {
        val text =
            "Version 2.3 of the new ACME widget is now live! Special thanks to @[Joe Bloggs](567) and" +
                    " @[福 岡 正信](123) for all their hard work on getting this out the door. " +
                    "@[Joe Bloggs](567) will be monitoring adoption for the next three weeks."

        println(presenter.textToMarkdown(text))
    }
}