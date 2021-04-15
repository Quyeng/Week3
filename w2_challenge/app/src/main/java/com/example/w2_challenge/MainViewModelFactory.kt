package com.example.w2_challenge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(val userName: String, val email: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(userName, email) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}