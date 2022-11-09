package com.volkankelleci.oop

import android.telecom.Call
import com.volkankelleci.oop.model.nutrition
import io.reactivex.Single
import retrofit2.http.GET

interface nutritionAPI {
    @GET("atilsamancioglu/BTK20-JSONVeriSeti/blob/master/besinler.json")
    fun getNutrition(): Single<List<nutrition>>
}