package com.volkankelleci.oop.viewmodel

import android.app.Application
import androidx.compose.runtime.currentCompositeKeyHash
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.volkankelleci.oop.model.nutrition
import com.volkankelleci.oop.service.DAO
import com.volkankelleci.oop.service.NutritionDataBase
import kotlinx.coroutines.launch
import java.util.UUID

class NutritionContentViewModel(application: Application):BaseCoroutineScope(application) {

    val besinLiveData=MutableLiveData<nutrition>()

    val nutritionData=MutableLiveData<nutrition>()
     fun roomVersionTake(uuid: Int){
       launch {
           val dao=NutritionDataBase(getApplication()).besinDAO()
           val besin=dao.getBesin(uuid)
           besinLiveData.value=besin
       }

    }
}