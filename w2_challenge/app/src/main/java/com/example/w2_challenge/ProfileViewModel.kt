package com.example.w2_challenge

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel(userName: String, email: String) : ViewModel() {
    var account : MutableLiveData<Account> = MutableLiveData()
    init {
        account.value = Account(email, userName)
    }

    fun setAccountUserName(userName: String){
        account.value?.username = userName
        account.postValue(account.value)
    }
    fun setEmailtUserName(email: String){
        account.value?.email = email
        account.postValue(account.value)
    }
}