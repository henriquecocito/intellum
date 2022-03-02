package com.henriquecocito.intellum.presentation

import com.henriquecocito.intellum.domain.useCases.createLink.CreateLinkParam
import com.henriquecocito.intellum.domain.useCases.createLink.CreateLinkUseCase
import com.henriquecocito.intellum.domain.useCases.getUsersFromText.GetUsersFromTextUseCase

internal class IntellumPresenter(
    private val getUsersFromTextUseCase: GetUsersFromTextUseCase,
    private val createLinkUseCase: CreateLinkUseCase
) {

    fun textToMarkdown(text: String): String {
        if (text.isEmpty()) return text
        val users = getUsersFromTextUseCase.execute(text)
        var currentText = text
        users.forEach {
            currentText = createLinkUseCase.execute(CreateLinkParam(currentText, it))
        }

        return currentText
    }
}