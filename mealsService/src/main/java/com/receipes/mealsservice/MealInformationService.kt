package com.receipes.mealsservice

import retrofit2.http.GET

interface MealInformationService {
    @GET("search.php?s={mealName}")
    suspend fun getMealInformation(): MealInformation
}