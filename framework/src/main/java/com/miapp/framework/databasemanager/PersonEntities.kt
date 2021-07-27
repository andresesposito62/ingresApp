package com.miapp.framework.databasemanager

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var identification : String,
    var names : String,
    var surnames : String,
    var phone : String,
    var temperature : String,
    var rol : String
)