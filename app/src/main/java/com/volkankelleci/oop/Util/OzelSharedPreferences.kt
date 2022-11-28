package com.volkankelleci.oop.Util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class OzelSharedPreferences {

    companion object{

        private var sharedPreferences:SharedPreferences?=null

        @Volatile private var instance:OzelSharedPreferences?=null
        private val lock=Any()
        operator fun invoke(context: Context):OzelSharedPreferences= instance?: synchronized(lock){

            instance?: ozelSharedPreferencesYap(context).also {
                instance=it
            }
        }
        private fun ozelSharedPreferencesYap(context: Context):OzelSharedPreferences{
            sharedPreferences=androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
            return OzelSharedPreferences()
        }


    }
}