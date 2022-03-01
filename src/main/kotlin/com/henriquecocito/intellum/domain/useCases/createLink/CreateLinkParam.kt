package com.henriquecocito.intellum.domain.useCases.createLink

import com.henriquecocito.intellum.entities.models.User

data class CreateLinkParam(
    val text: String,
    val user: User
)