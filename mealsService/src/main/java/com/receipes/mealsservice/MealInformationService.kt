package com.receipes.mealsservice

import retrofit2.http.GET
import retrofit2.http.Path

interface MealInformationService {
    @GET("search.php?s={mealName}")
    suspend fun getMealInformation(@Path("mealName") mealName: String): MealInformation
}