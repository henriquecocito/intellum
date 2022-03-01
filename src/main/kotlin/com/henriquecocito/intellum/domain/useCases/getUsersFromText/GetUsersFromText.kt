package com.henriquecocito.intellum.domain.useCases.getUsersFromText

import com.henriquecocito.intellum.entities.models.User

internal class GetUsersFromText : GetUsersFromTextUseCase {

    private val regex = "@\\[(.+?)\\]\\(([0-9]+?)\\)".toRegex()

    override fun execute(param: String): Set<User> =
        regex.findAll(param).map {
            User(it.groupValues[2], it.groupValues[1])
        }.toSet()
}