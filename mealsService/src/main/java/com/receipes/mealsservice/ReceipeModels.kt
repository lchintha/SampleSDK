package com.receipes.mealsservice

data class MealCategories(
    val categories: List<Category>
)

data class Category(
    val id: String,
    val name: String,
    val image: String,
    val description: String
)

data class MealInformationRequest(
    val mealName: String
)

data class MealInformation(
    val meal: List<MealInfo>
)

data class MealInfo(
    val id: String,
    val name: String,
    val category: String,
    val origin: String,
    val instructions: String,
    val image: String,
    val videoLink: String,
    val ingredient1: String,
    val ingredient2: String,
    val ingredient3: String,
    val ingredient4: String,
    val ingredient5: String,
    val measure1: String,
    val measure2: String,
    val measure3: String,
    val measure4: String,
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
    )
}

fun getError(type: ErrorType): Error{
    return Error(
        type,
        type.code,
        type.description
    )
}