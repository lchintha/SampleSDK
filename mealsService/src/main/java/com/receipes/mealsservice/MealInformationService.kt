package com.receipes.mealsservice

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MealInformationService {
    @GET("search.php")
    suspend fun getMealInformation(@Query("s") mealName: String): MealInformation
}