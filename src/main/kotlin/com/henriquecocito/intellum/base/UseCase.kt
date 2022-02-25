package com.henriquecocito.intellum.base

interface UseCase<P, R> {
    fun execute(param: P): R
}