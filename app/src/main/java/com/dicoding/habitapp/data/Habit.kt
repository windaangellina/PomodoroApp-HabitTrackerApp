package com.dicoding.habitapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//TODO 1 : Define a local database table using the schema in app/schema/habits.json
@Parcelize
data class Habit(
    val id: Int = 0,
    val title: String,
    val minutesFocus: Long,
    val startTime: String,
    val priorityLevel: String
): Parcelable
