package com.example.offlineclinic

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Patient::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun patientDao(): PatientDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "clinic_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}