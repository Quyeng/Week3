package ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week3.databinding.ActivityProfileBinding
import com.example.week3.R
import data.AccountDataStore
import androidx.lifecycle.asLiveData
import androidx.lifecycle.Observer

class ProfileActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityProfileBinding
    private  lateinit var profilViewModel : ProfileViewModel
    private  lateinit var profileViewModelFactory: ProfileViewModelFactory
    private lateinit var accountDataStore: AccountDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_profile)
        profileViewModelFactory = ProfileViewModelFactory(fullName = "",email = "",passWord = "")
        profilViewModel = ViewModelProvider(this,profileViewModelFactory).get(ProfileViewModel::class.java)
        accountDataStore = AccountDataStore(this)

        observeData()

    }
    private fun observeData() {

        accountDataStore.user.asLiveData().observe(this, Observer {
            binding.txvEmail.text = it?.email
            binding.txvFullName.text = it?.fullName
        })
    }
}