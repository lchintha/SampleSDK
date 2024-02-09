package com.example.samplesdk

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.receipes.mealsfeature.MealsInterface
import com.receipes.mealsfeature.MealsInterfaceFactory
import com.receipes.mealsfeature.MealsListener
import com.receipes.mealsservice.MealCategories
import com.receipes.mealsservice.MealError
import com.receipes.mealsservice.MealInformation
import com.receipes.mealsservice.MealInformationRequest

class MealsViewModel : ViewModel() {

    private lateinit var mealsInterface: MealsInterface

    private val _observeMealCategories = MutableLiveData<MealCategories>()
    val observeMealCategories: LiveData<MealCategories> get() = _observeMealCategories
    private val _observeMealInformation = MutableLiveData<MealInformation>()
    val observeMealInformation: LiveData<MealInformation> get() = _observeMealInformation
    private val _observeError = MutableLiveData<MealError>()
    val observeError: LiveData<MealError> get() = _observeError


    val screenLoading = mutableStateOf(false)

    fun initSDK(){
        mealsInterface = MealsInterfaceFactory.createMealsInterface(
            object : MealsListener {
                override fun getMealCategoriesSuccess(
                    mealInterface: MealsInterface,
                    response: MealCategories
                ) {
                    _observeMealCategories.postValue(
                        response
                    )
                    screenLoading.value = false
                }

                override fun getMealCategoriesFailure(
                    mealInterface: MealsInterface,
                    mealError: MealError
                ) {
                    _observeError.postValue(
                        mealError
                    )
                    screenLoading.value = false
                }

                override fun getMealInformationSuccess(
                    mealInterface: MealsInterface,
                    response: MealInformation
                ) {
                    _observeMealInformation.postValue(
                        response
                    )
                    screenLoading.value = false
                }

                override fun getMealInformationFailure(
                    mealInterface: MealsInterface,
                    mealError: MealError
                ) {
                    _observeError.postValue(
                        mealError
                    )
                    screenLoading.value = false
                }
            }
        )
    }

    fun getMealCategories() {
        screenLoading.value = true
        mealsInterface.getMealCategories()
    }

    fun getMealInformation(name: String) {
        screenLoading.value = true
        mealsInterface.getMealInformation(
            MealInformationRequest(
                name
            )
        )
    }

}