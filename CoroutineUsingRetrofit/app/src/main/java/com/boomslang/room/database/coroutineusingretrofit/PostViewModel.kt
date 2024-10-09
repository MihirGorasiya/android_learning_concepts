package com.boomslang.room.database.coroutineusingretrofit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boomslang.room.database.coroutineusingretrofit.utils.Post
import com.boomslang.room.database.coroutineusingretrofit.utils.RetrofitInstance
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val _posts = mutableStateOf<List<Post>>(emptyList())
    val posts: State<List<Post>> = _posts

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val postList = RetrofitInstance.api.getPosts()
                _posts.value = postList
            } catch (e: Exception) {
                println("Error fetching posts: ${e.message}")
            }
        }
    }
}