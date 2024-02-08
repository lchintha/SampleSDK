package com.receipes.mealsfeature

import com.receipes.mealsfeature.impl.MealsInterfaceImpl

object MealsInterfaceFactory{

    fun createMealsInterface(
        mealsListener: MealsListener
    ) : MealsInterface {
        return MealsInterfaceImpl(mealsListener)
    }

}