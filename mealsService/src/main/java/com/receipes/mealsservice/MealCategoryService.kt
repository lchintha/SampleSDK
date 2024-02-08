package com.receipes.mealsservice

import retrofit2.http.GET

interface MealCategoriesService {
    @GET("categories.php")
    suspend fun getMealCategories(): MealCategories
}