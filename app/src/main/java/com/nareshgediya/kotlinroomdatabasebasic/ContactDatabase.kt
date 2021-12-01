package com.nareshgediya.kotlinroomdatabasebasic

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 2)
@TypeConverters(Convertors::class)
abstract class ContactDatabase : RoomDatabase() {

abstract fun contactDao() :ContactDao
companion object{
    @Volatile
    private var INSTANCE : ContactDatabase? = null


    //For Updating the version of Database
    val version1_2 = object : Migration(1,2){

        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("Alter Table contacts Add column isActive Integer Not null default(1)")
        }
    }

    fun getDatabse (context: Context) : ContactDatabase{
        synchronized(this){
            if (INSTANCE == null){
                INSTANCE = Room.
                databaseBuilder(context.applicationContext,
                    ContactDatabase::class.java,"ContactDB")
                    .addMigrations(version1_2)   //this line for database updation
                    .build()
            }
        }
        return INSTANCE!!
    }

}

}