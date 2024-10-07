package com.boomslang.room.database.roomdatabaseapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.boomslang.room.database.roomdatabaseapp.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun getAllTodo(): LiveData<List<Todo>>

    @Insert
    fun addTodo(todo: Todo)

    @Query("DELETE FROM todo WHERE id = :id")
    fun deleteTodo(id: Int)

}