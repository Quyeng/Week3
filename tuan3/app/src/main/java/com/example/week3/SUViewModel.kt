package com.example.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SUViewModel : ViewModel() {
    val user = MutableLiveData<User>()
    var isSignUpSucceed = MutableLiveData<Boolean>()
    var errorMessage = MutableLiveData<String>()

    init {
        user.value = User()
    }

    fun signUp() {
        val dataStore = DataStore.instance
        dataStore.setSignUpCallback(signUpCallback)
        dataStore.signUp(user.value!!.fullName, user.value!!.email, user.value!!.password)
    }

    fun clear(){
        isSignUpSucceed.value = null
        errorMessage.value = null
    }



    private val signUpCallback  = object : DataStore.SignUpCallback{
        override fun onSucceed() {
            isSignUpSucceed.value = true
        }

        override fun onFailed(message: String) {
            isSignUpSucceed.value = false
            errorMessage.value = message
        }
    }
}