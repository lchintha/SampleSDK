package com.receipes.mealsfeature

import com.receipes.mealsservice.MealError
import com.receipes.mealsservice.MealCategories
import com.receipes.mealsservice.MealInformation

interface MealsListener {

    fun getMealCategoriesSuccess(mealInterface: MealsInterface, response: MealCategories)
    fun getMealCategoriesFailure(mealInterface: MealsInterface, mealError: MealError)

    fun getMealInformationSuccess(mealInterface: MealsInterface, response: MealInformation)
    fun getMealInformationFailure(mealInterface: MealsInterface, mealError: MealError)

}