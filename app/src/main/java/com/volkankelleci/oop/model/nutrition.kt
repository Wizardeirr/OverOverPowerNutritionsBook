package com.volkankelleci.oop.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class nutrition(
    @ColumnInfo(name= "isim")        @SerializedName("isim")  val nutritionName:String?,
    @ColumnInfo(name= "kalori")      @SerializedName("kalori") val nutritionkcal:String?,
    @ColumnInfo(name= "karbonhidrat")@SerializedName("karbonhidrat") val nutritionCarbonhydrate:String?,
    @ColumnInfo(name= "protein")     @SerializedName("protein") val nutritionProtein:String?,
    @ColumnInfo(name= "yag")         @SerializedName("yag") val nutritionFat:String?,
    @ColumnInfo(name= "gorsel")      @SerializedName("gorsel") val nutritionImage:String?,
) {
    @PrimaryKey (autoGenerate = true)
    var uuid:Int=0
}