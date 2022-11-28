package com.volkankelleci.oop.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.volkankelleci.oop.Util.OzelSharedPreferences
import com.volkankelleci.oop.model.nutrition
import com.volkankelleci.oop.service.NutritionDataBase
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
    private var guncellemeZamani=10 * 60 * 1000 * 1000 * 1000L
    private val nutritionAPIService=nutritionRetrofit()
    private val disposable=CompositeDisposable()
    private val ozelSharedPreferences=OzelSharedPreferences(getApplication())

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
                    nutritions.value=t
                    errorMessage.value=false
                    progressBar.value=false
                    Toast.makeText(getApplication(),"Besinleri Internetten Aldık",Toast.LENGTH_LONG).show()
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

}

