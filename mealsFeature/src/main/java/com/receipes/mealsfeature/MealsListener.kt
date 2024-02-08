package com.receipes.mealsfeature

import com.receipes.mealsservice.Error
import com.receipes.mealsservice.MealCategories
import com.receipes.mealsservice.MealInformation

interface MealsListener {

    fun getMealCategoriesSuccess(mealInterface: MealsInterface, response: MealCategories)
    fun getMealCategoriesFailure(mealInterface: MealsInterface, error: Error)

    fun getMealInformationSuccess(mealInterface: MealsInterface, response: MealInformation)
    fun getMealInformationFailure(mealInterface: MealsInterface, error: Error)

}