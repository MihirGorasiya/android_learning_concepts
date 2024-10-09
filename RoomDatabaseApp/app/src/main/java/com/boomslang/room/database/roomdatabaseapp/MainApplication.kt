package com.boomslang.room.database.roomdatabaseapp

import android.app.Application
import androidx.room.Room
import com.boomslang.room.database.roomdatabaseapp.db.TodoDatabase

class MainApplication : Application() {
    companion object {
        lateinit var todoDatabase: TodoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        todoDatabase =
            Room.databaseBuilder(
                applicationContext,
                TodoDatabase::class.java,
                TodoDatabase.NAME,
            ).build()
    }
}