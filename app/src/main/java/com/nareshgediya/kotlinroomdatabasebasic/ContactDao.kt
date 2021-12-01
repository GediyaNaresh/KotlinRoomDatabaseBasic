package com.nareshgediya.kotlinroomdatabasebasic

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {

    @Insert
  suspend  fun insertContact(contact: Contact)

    @Update
    suspend  fun updateContact(contact: Contact)

    @Delete
    suspend  fun deleteContact(contact: Contact)


    @Query("select * from contacts")
    fun getContact() : LiveData<List<Contact>>
}