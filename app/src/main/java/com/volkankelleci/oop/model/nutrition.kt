package com.volkankelleci.oop.model

import com.google.gson.annotations.SerializedName

data class nutrition(
    @SerializedName("isim")
    val nutritionName:String?,
    @SerializedName("kalori")
    val nutritionkcal:String?,
    @SerializedName("karbonhidrat")
    val nutritionCarbonhydrate:String?,
    @SerializedName("protein")
    val nutritionProtein:String?,
    @SerializedName("yag")
    val nutritionFat:String?,
    @SerializedName("gorsel")
    val nutritionImage:String?,
) {
}