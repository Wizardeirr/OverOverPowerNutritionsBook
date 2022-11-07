package com.volkankelleci.oop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.volkankelleci.oop.model.nutrition

class nutritionsViewModel: ViewModel() {
    val nutritions=MutableLiveData<List<nutrition>>()
    val errorMessage=MutableLiveData<Boolean>()
    val progressBar=MutableLiveData<Boolean>()
    fun refreshData(){
        val muz =nutrition("Muz","3","4","5","7","www.bombabomba.com")
        val cilek =nutrition("cilek","4","6","8","10","www.bombabomba.com")
        val armut =nutrition("armut","5","7","9","11","www.bombabomba.com")

        val nutritionData= arrayListOf<nutrition>(muz,cilek,armut)
        nutritions.value=nutritionData
        errorMessage.value=false
        progressBar.value=false


    }
}