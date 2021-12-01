package com.nareshgediya.kotlinroomdatabasebasic

import androidx.room.TypeConverter
import java.util.*


class Convertors {

    @TypeConverter
    fun datrToLong(date : Date) : Long
    {
        return date.time
    }

    @TypeConverter
    fun datrToLong(date : Long) : Date
    {
        return Date(date)
    }


}