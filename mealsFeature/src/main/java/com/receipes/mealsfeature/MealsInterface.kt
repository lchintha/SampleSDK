package com.receipes.mealsfeature

import com.receipes.mealsservice.MealInformationRequest

interface MealsInterface {

    fun getMealCategories()
    fun getMealInformation(request: MealInformationRequest)

}