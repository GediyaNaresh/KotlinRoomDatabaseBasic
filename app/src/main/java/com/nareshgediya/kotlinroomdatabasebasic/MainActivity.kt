package com.nareshgediya.kotlinroomdatabasebasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.room.PrimaryKey
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // this is using singletone pattern
        database = ContactDatabase.getDatabse(this)
       val database2 = ContactDatabase.getDatabse(this)

        //this is direct uses
//        database = Room.databaseBuilder(applicationContext,
//            ContactDatabase::class.java,
//            "ContactDB").build()



    }

    fun OnCLicked(view: View) {
        GlobalScope.launch {

            database.contactDao().insertContact(Contact(0,"Naresh","973667ada8",Date(),1))
        }

    }

    fun update(view: android.view.View) {
        GlobalScope.launch {
            database.contactDao().updateContact(Contact(8,"Gediya","8666",Date(),2))


        }

    }

    fun showdata(view: android.view.View) {
        database.contactDao().getContact().observe(this,{
            Log.d("TAG", it.toString())
        })
    }


}