package com.henriquecocito.intellum.domain.useCases.getUsersFromText

import com.henriquecocito.intellum.base.UseCase
import com.henriquecocito.intellum.entities.models.User

interface GetUsersFromTextUseCase : UseCase<String, Set<User>>