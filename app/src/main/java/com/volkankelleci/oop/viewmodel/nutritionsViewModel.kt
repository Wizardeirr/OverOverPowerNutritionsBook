package com.volkankelleci.oop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.volkankelleci.oop.model.nutrition
import com.volkankelleci.oop.model.nutritionRetrofit
import com.volkankelleci.oop.nutritionAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

class nutritionsViewModel: ViewModel() {
    val nutritions=MutableLiveData<List<nutrition>>()
    val errorMessage=MutableLiveData<Boolean>()
    val progressBar=MutableLiveData<Boolean>()

    private val nutritionAPIService=nutritionRetrofit()
    private val disposable=CompositeDisposable()
    fun refreshData(){

    }
    private fun takesToDataFromInternet(){



        disposable.add(
            nutritionAPIService.getdata()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<nutrition>>(){
                    override fun onSuccess(t: List<nutrition>) {
                        nutritions.value=t
                        errorMessage.value=false
                        progressBar.value=false

                    }

                    override fun onError(e: Throwable) {
                        errorMessage.value=true
                        progressBar.value=false
                        e.printStackTrace()
                    }

                }

        ))
    }
}