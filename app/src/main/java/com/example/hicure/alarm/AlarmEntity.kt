package com.example.hicure.alarm

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_alarm")
data class AlarmEntity(
    @PrimaryKey
    val id: Int = 0,
    val alarmLabel: String = "",
    val time: String = "",
    val amPm: String = "",
    val alarmEnabled: Boolean = false
)