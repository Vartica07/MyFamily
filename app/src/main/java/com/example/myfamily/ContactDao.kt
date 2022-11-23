package com.example.myfamily

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao    //data access object
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contactModel: ContactModel)  //suspend will always make a function to run in coroutine scope, IO(background) thread
            //we can perform basic functions like pause, resume in suspend

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(contactModel: List<ContactModel>)

    @Query("SELECT * FROM contactmodel")
    fun getAllContacts(): LiveData<List<ContactModel>>   //live listner, always runs on main thread



}