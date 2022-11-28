package com.volkankelleci.oop.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.volkankelleci.oop.model.nutrition
import com.volkankelleci.oop.service.DAO
import com.volkankelleci.oop.service.NutritionDataBase
import com.volkankelleci.oop.service.apiCreate
import com.volkankelleci.oop.service.nutritionRetrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class nutritionsViewModel(application: Application):BaseCoroutineScope(application) {
    val nutritions=MutableLiveData<List<nutrition>>()
    val errorMessage=MutableLiveData<Boolean>()
    val progressBar=MutableLiveData<Boolean>()

    private val nutritionAPIService=nutritionRetrofit()
    private val disposable=CompositeDisposable()

    fun refreshData(){
        takesToDataFromInternet()

    }
    private fun takesToDataFromInternet(){

    disposable.add(
        nutritionAPIService.getdata()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<nutrition>>() {
                override fun onSuccess(t: List<nutrition>) {
                    sqLiteSakla(t)
                }

                override fun onError(e: Throwable) {
                    errorMessage.value=true
                    progressBar.value=false
                    e.printStackTrace()
                }
            })
    )
    }
    private fun besinleriGoster(besinlerListesi:List<nutrition>){
        nutritions.value=besinlerListesi
        errorMessage.value=false
        progressBar.value=false
    }
    private fun sqLiteSakla(besinListesi:List<nutrition>){

        launch {
            val dao=NutritionDataBase(getApplication()).besinDAO()
            dao.deleteAllBesin()
            val uuidListesi=dao.insertAll(*besinListesi.toTypedArray())
            var i = 0
            while (i < besinListesi.size){
                besinListesi[i].uuid=uuidListesi[i].toInt()
                i=i+1
            }
        }
        besinleriGoster(besinListesi)
    }
}

