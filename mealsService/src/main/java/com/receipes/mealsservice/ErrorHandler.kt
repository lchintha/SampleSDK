package com.receipes.mealsservice

object ErrorHandler {
    fun getError(type: ErrorType): MealError{
        return MealError(
            type,
            type.code,
            type.description
        )
    }

}