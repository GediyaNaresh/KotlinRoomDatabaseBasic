package com.nareshgediya.kotlinroomdatabasebasic

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import java.util.*

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id :Long,
    val name: String,
    val phone :String,
    val createdDate : Date,
    val isActive : Int
)
