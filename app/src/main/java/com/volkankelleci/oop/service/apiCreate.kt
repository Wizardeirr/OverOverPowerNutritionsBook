package com.volkankelleci.oop.service

import com.volkankelleci.oop.model.nutrition
import io.reactivex.Single
import retrofit2.http.GET

interface apiCreate {
    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    fun getNutrition(): Single<List<nutrition>>
}