package com.receipes.mealsfeature.impl

import com.receipes.mealsfeature.MealsInterface
import com.receipes.mealsfeature.MealsListener
import com.receipes.mealsservice.ErrorHandler
import com.receipes.mealsservice.ErrorType
import com.receipes.mealsservice.MealCategoriesService
import com.receipes.mealsservice.MealInformationRequest
import com.receipes.mealsservice.MealInformationService
import com.receipes.mealsservice.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class MealsInterfaceImpl(private val listener: MealsListener) : MealsInterface {
    override fun getMealCategories() {
        CoroutineScope(Dispatchers.IO).launch {
            val retrofitClient = RetrofitClient.getInstance()
            val service = retrofitClient.create(MealCategoriesService::class.java)
            val mealCategories = service.getMealCategories()
            withContext(Dispatchers.Main) {
                listener.getMealCategoriesSuccess(
                    this@MealsInterfaceImpl,
                    mealCategories
                )
            }
        }
    }

    override fun getMealInformation(request: MealInformationRequest) {
        if(request.mealName.isBlank()){
            listener.getMealInformationFailure(
                this,
                ErrorHandler.getError(ErrorType.EmptyMealName)
            )
            return
        }
        getMealInformation(request.mealName)
    }

    private fun getMealInformation(mealName: String){
        CoroutineScope(Dispatchers.IO).launch {
            val retrofitClient = RetrofitClient.getInstance()
            val service = retrofitClient.create(MealInformationService::class.java)
            val mealInformation = service.getMealInformation(mealName)
            withContext(Dispatchers.Main) {
                if(mealInformation.meal.isNullOrEmpty()){
                    listener.getMealInformationFailure(
                        this@MealsInterfaceImpl,
                        ErrorHandler.getError(ErrorType.NoMealInformationAvailable)
                    )
                } else {
                    listener.getMealInformationSuccess(
                        this@MealsInterfaceImpl,
                        mealInformation
                    )
                }
            }
        }
    }
}