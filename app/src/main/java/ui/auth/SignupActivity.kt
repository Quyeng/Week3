package ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week3.R
import com.example.week3.databinding.ActivitySignupBinding
import android.content.Intent
import androidx.lifecycle.lifecycleScope
import data.AccountDataStore
import kotlinx.coroutines.launch


class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var signupViewModel: SignupViewModel
    private lateinit var signupViewModelFactory: SignupViewModelFactory
    private lateinit var accountDataStore: AccountDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this,R.layout.activity_signup)
        signupViewModelFactory = SignupViewModelFactory(fullName = "",email = "",passWord = "")
        signupViewModel = ViewModelProvider(this,signupViewModelFactory).get(SignupViewModel::class.java)
        accountDataStore = AccountDataStore(this)
        binding.apply {

            btnSignup.setOnClickListener{
                var fullName = edtFullName.text.toString().trim()
                var email = edtEmail.text.toString().trim()
                var passWord = edtPassword.text.toString().trim()
                //Stores the values
//                if (fullName == null || email == null || passWord == null){
//                    To
//                }
                    lifecycleScope.launch {
                    accountDataStore.storeData(fullName, email, passWord)
                }
                val intent = Intent(this@SignupActivity,LoginActivity::class.java)
                startActivity(intent)

            }
        }

    }
}