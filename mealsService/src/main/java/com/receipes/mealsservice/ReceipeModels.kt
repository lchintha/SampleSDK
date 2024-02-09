package com.receipes.mealsservice

import com.google.gson.annotations.SerializedName

data class MealCategories(
    @SerializedName("categories")
    val categories: List<Category>
)

data class Category(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val name: String,
    @SerializedName("strCategoryThumb")
    val image: String,
    @SerializedName("strCategoryDescription")
    val description: String
)

data class MealInformationRequest(
    val mealName: String
)

data class MealInformation(
    @SerializedName("meals")
    val meal: List<MealInfo>?
)

data class MealInfo(
    @SerializedName("idMeal")
    val id: String,
    @SerializedName("strMeal")
    val name: String,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strArea")
    val origin: String,
    @SerializedName("strInstructions")
    val instructions: String,
    @SerializedName("strMealThumb")
    val image: String,
    @SerializedName("strYoutube")
    val videoLink: String,
    @SerializedName("strIngredient1")
    val ingredient1: String,
    @SerializedName("strIngredient2")
    val ingredient2: String,
    @SerializedName("strIngredient3")
    val ingredient3: String,
    @SerializedName("strIngredient4")
    val ingredient4: String,
    @SerializedName("strIngredient5")
    val ingredient5: String,
    @SerializedName("strMeasure1")
    val measure1: String,
    @SerializedName("strMeasure2")
    val measure2: String,
    @SerializedName("strMeasure3")
    val measure3: String,
    @SerializedName("strMeasure4")
    val measure4: String,
    @SerializedName("strMeasure5")
    val measure5: String,
)

data class Error(
    val type: ErrorType,
    val code: String,
    val description: String
)

enum class ErrorType(
    val code: String,
    val description: String
){
    NoNetwork(
        "ERROR_101",
        "Network is not available."
    ),
    EmptyMealName(
        "ERROR_102",
        "Meal name should not be empty."
    ),
    NoMealInformationAvailable(
        "ERROR_103",
        "Meal information is not available for the give input."
    )
}