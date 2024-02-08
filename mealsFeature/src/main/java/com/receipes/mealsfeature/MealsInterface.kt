package com.receipes.mealsfeature

import com.receipes.mealsservice.MealInformation

interface MealsInterface {

    fun getMealCategories()
    fun getMealInformation(request: MealInformation)

}