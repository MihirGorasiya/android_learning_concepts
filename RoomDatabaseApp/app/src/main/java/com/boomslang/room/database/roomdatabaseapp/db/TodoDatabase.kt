package com.boomslang.room.database.roomdatabaseapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.boomslang.room.database.roomdatabaseapp.Todo

@Database(entities = [Todo::class], version = 1)
@TypeConverters(Converters::class)

abstract class TodoDatabase : RoomDatabase() {
    companion object {
        const val NAME = "todo_db"
    }
    abstract fun getTodoDao(): TodoDao
}