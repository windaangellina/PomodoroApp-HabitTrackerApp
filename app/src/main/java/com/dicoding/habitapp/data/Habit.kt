package com.dicoding.habitapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dicoding.habitapp.utils.HABIT_TABLE_NAME
import kotlinx.parcelize.Parcelize

//TODO 1 : Define a local database table using the schema in app/schema/habits.json
@Entity(tableName = HABIT_TABLE_NAME)
@Parcelize
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val minutesFocus: Long,
    val startTime: String,
    val priorityLevel: String
): Parcelable
