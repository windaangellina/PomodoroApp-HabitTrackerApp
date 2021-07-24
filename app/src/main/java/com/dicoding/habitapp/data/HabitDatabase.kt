package com.dicoding.habitapp.data

import android.content.Context
import androidx.room.RoomDatabase
import com.dicoding.habitapp.R
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

//TODO 3 : Define room database class and prepopulate database using JSON
abstract class HabitDatabase : RoomDatabase() {

    abstract fun habitDao(): HabitDao

    companion object {

        @Volatile
        private var INSTANCE: HabitDatabase? = null

        fun getInstance(context: Context): HabitDatabase {
            throw NotImplementedError("Not yet implemented")
        }

        private fun fillWithStartingData(context: Context, dao: HabitDao) {
            val jsonArray = loadJsonArray(context)
            try {
                if (jsonArray != null) {
                    for (i in 0 until jsonArray.length()) {
                        val item = jsonArray.getJSONObject(i)
                        dao.insertAll(
                            Habit(
                                item.getInt("id"),
                                item.getString("title"),
                                item.getLong("focusTime"),
                                item.getString("startTime"),
                                item.getString("priorityLevel")
                            )
                        )
                    }
                }
            } catch (exception: JSONException) {
                exception.printStackTrace()
            }
        }

        private fun loadJsonArray(context: Context): JSONArray? {
            val builder = StringBuilder()
            val `in` = context.resources.openRawResource(R.raw.habit)
            val reader = BufferedReader(InputStreamReader(`in`))
            var line: String?
            try {
                while (reader.readLine().also { line = it } != null) {
                    builder.append(line)
                }
                val json = JSONObject(builder.toString())
                return json.getJSONArray("habits")
            } catch (exception: IOException) {
                exception.printStackTrace()
            } catch (exception: JSONException) {
                exception.printStackTrace()
            }
            return null
        }

    }
}
