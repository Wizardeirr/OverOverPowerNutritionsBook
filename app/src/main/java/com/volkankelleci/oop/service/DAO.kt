package com.volkankelleci.oop.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.volkankelleci.oop.model.nutrition
@Dao
interface DAO {
    @Insert
    suspend fun insertAll(vararg besin:nutrition) : List<Long>
    //Insert -> Room, insert into
    //suspend -> coroutine scope
    // vararg -> birden fazla ve istediğimiz sayıda besin
    //List<Long> -> long, idler uuid

    @Query("SELECT*FROM nutrition")
    suspend fun getallBesin():List<nutrition>

    @Query("SELECT *FROM nutrition WHERE uuid= :besinId")
    suspend fun getBesin(besinId:Int):nutrition

    @Query("DELETE  FROM nutrition")
    suspend fun deleteAllBesin()
}