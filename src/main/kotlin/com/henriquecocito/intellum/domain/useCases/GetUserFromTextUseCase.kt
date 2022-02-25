package com.henriquecocito.intellum.domain.useCases

import com.henriquecocito.intellum.base.UseCase
import com.henriquecocito.intellum.entities.User

interface GetUserFromTextUseCase : UseCase<String, Set<User>>