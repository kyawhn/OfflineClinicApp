package com.example.offlineclinic

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "patients")
data class Patient(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val visitNote: String
)