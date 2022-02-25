package com.henriquecocito.intellum.domain.useCases

import com.henriquecocito.intellum.base.UseCase
import com.henriquecocito.intellum.entities.User

interface GetUsersFromTextUseCase : UseCase<String, Set<User>>