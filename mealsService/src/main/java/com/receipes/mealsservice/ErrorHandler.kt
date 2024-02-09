package com.receipes.mealsservice

object ErrorHandler {
    fun getError(type: ErrorType): Error{
        return Error(
            type,
            type.code,
            type.description
        )
    }

}