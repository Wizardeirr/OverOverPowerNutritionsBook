package com.volkankelleci.oop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.volkankelleci.oop.model.nutrition

class NutritionContentViewModel: ViewModel() {

    val nutritionData=MutableLiveData<nutrition>()
    fun roomVersionTake(){
        val cilek =nutrition("cilek","4","6","8","10","www.bombabomba.com")
        nutritionData.value=cilek
    }
}