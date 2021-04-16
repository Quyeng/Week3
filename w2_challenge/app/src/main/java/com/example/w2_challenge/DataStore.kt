package com.example.w2_challenge

class DataStore () {
    private val List = ArrayList<Detail>()
    private lateinit var loginCallback: LoginCallback
    private lateinit var signUpCallback: SignUpCallback

    companion object {
        val instance = DataStore()

        const val FULL_NAME = 0
        const val EMAIL = 1
        const val PHONE_NUMBER = 2

    }
    fun signUp(fullName: String, email: String, password: String) {
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            signUpCallback.onFailed("Field cannot empty")
        } else {
            for (user in List) {
                if (user.email == email) {
                    signUpCallback.onFailed("This email is already existed")
                    return
                }
            }
            val user = Detail(fullName, email, password)
            List.add(user)
            signUpCallback.onSucceed()


        }
    }

    fun login(email: String, password: String) {
        for (user in List) {
            if (user.email == email && user.password == password) {
                loginCallback.onSucceed(user)
                return
            }
        }
        loginCallback.onFailed("Cannot find any user")
    }

    fun getUserByEmail(email: String): Detail?{
        for(user in List){
            if(user.email == email){
                return user
            }
        }
        return null
    }

    fun editUser(email: String, field: Int, value: String) {
        for (user in List) {
            if (user.email == email) {
                when (field) {
                    FULL_NAME -> {
                        user.fullName = value
                    }
                    EMAIL -> {
                        user.email = value
                    }
                    PHONE_NUMBER -> {
                        user.phoneNumber = value
                    }
                }
            }
        }
    }
    @Override
    fun setSignUpCallback(signUpCallback: SignUpCallback) {
        this.signUpCallback = signUpCallback
    }

    fun setLoginCallback(loginCallback: LoginCallback) {
        this.loginCallback = loginCallback
    }

    interface LoginCallback {
        fun onSucceed(user:Detail)
        fun onFailed(message: String)

    }

    interface SignUpCallback {
        fun onSucceed()
        fun onFailed(message: String)
    }
}