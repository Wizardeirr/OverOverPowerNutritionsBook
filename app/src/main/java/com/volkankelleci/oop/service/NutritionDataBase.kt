package com.volkankelleci.oop.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.volkankelleci.oop.Adapter.NutritionRecyclerAdapter
import com.volkankelleci.oop.model.nutrition

@Database(entities = arrayOf(nutrition::class), version = 1)
abstract class NutritionDataBase :RoomDatabase() {
    abstract fun besinDAO():DAO

    //Singleton : Tek bir obje oluşturmak için Companion Object içine koymamız lazım
    //Sebebi büyük projelerde çakışmaması için
    companion object{
        //Volatile diğer tredlere de görünür yapar.
        @Volatile private var instance:NutritionDataBase?=null
        private val lock=Any()
        operator fun invoke(context:Context) = instance ?: synchronized(lock){
            instance?: dataBaseOlustur(context).also {
                instance=it
            }
        }
        //invoke = ateşlemek başlatmak , senkronize bir şekilde instance oluşturulduysa onu döndür,
        //eğer oluşturulmadıysa senkronize yap.
        //instance?: = Elvis Operatürü.
        private fun dataBaseOlustur(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            NutritionDataBase::class.java,"besinDataBase").build()
    }
}