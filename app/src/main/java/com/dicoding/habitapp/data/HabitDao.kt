package com.dicoding.habitapp.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.sqlite.db.SupportSQLiteQuery

//TODO 2 : Define data access object (DAO)
interface HabitDao {

    fun getHabits(query: SupportSQLiteQuery): DataSource.Factory<Int, Habit>

    fun getHabitById(habitId: Int): LiveData<Habit>

    fun insertHabit(habit: Habit): Long

    fun insertAll(vararg habits: Habit)

    fun deleteHabit(habits: Habit)

    fun getRandomHabitByPriorityLevel(level: String): LiveData<Habit>
}
