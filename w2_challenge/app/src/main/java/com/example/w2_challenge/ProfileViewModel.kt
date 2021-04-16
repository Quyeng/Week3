package com.example.w2_challenge

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel(fullname:String,email: String, passWord: String) : ViewModel() {
    var account : MutableLiveData<Account> = MutableLiveData()
    init {
        account.value = Account(fullname,email,passWord)
    }

    fun setAccountUserName(fullname: String){
        account.value?.fullname= fullname
        account.postValue(account.value)
    }
    fun setEmailtUserName(email: String){
        account.value?.email = email
        account.postValue(account.value)
    }
    fun setPasswordtUserName(passWord: String){
        account.value?.password = passWord
        account.postValue(account.value)
    }
}