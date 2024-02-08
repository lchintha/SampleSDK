package com.receipes.mealsfeature.impl

import com.receipes.mealsfeature.MealsInterface
import com.receipes.mealsfeature.MealsListener
import com.receipes.mealsservice.MealInformation

class MealsInterfaceImpl(val listener: MealsListener) : MealsInterface {
    override fun getMealCategories() {
        TODO("Not yet implemented")
    }

    override fun getMealInformation(request: MealInformation) {
        TODO("Not yet implemented")
    }
}