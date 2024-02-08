package com.receipes.mealsfeature

import com.receipes.mealsfeature.impl.MealsInterfaceImpl

object MealInterfaceFactory{

    fun createMealInterface(
        mealsListener: MealsListener
    ) : MealsInterface {
        return MealsInterfaceImpl(mealsListener)
    }

}