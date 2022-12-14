package com.volkankelleci.oop.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class BaseCoroutineScope(application: Application): AndroidViewModel(application),CoroutineScope {
    private val job= Job()
    override val coroutineContext: CoroutineContext
        get() =job+Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}