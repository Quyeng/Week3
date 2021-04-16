package com.example.w2_challenge
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.w2_challenge.databinding.ProfileBinding


class Profile : AppCompatActivity() {
    private lateinit var binding: ProfileBinding
    private lateinit var viewmodel: ProfileViewModel
    private  lateinit var viewdodelFactory: ProfileViewModelFactory
    private lateinit var accountDataStore: DataStore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModelBinding()

    }

    private fun setupViewModelBinding(){
        viewmodel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.profile)
        viewdodelFactory = ProfileViewModelFactory(fullName = "",email = "",passWord = "")
        accountDataStore = DataStore()

        observeData()

    }
    private fun observeData() {

            accountDataStore.Account.asLiveData().observe(this, Observer {
            binding.fname.text = it?.fullName
            binding.emailbox.text = it?.email
        })
    }
}


       /* binding.apply {
            val user = getUserFromBundle()
            user?.let {
                viewmodel.setupUserProfile(user.email)

            }

            tvFullName.setOnClickListener {
                setupAlertDialog("Edit Full Name", "Enter your full name",tvFullName.text.toString(),object:EditDialog.EditDialogCallback {
                    override fun onConfirmClicked(data: String) {
                        viewmodel.editFullNameUser(user!!.email,data)
                        showToastMessage(data)
                    }
                })
            }
            tvEmail.setOnClickListener {
                setupAlertDialog("Edit E-mail ", "Enter your e-mail",tvEmail.text.toString(),object :EditDialog.EditDialogCallback {
                    override fun onConfirmClicked(data: String) {
                        viewmodel.editEmailUser(user!!.email,data)
                        showToastMessage(data)

                    }
                })
            }
            tvPhoneNumber.setOnClickListener {
                setupAlertDialog("Edit Phone Number ", "Enter your phone number",tvPhoneNumber.text.toString(),object :EditDialog.EditDialogCallback {
                    override fun onConfirmClicked(data: String) {
                        viewmodel.editPhoneNumberUser(user!!.email,data)
                        showToastMessage(data)
                    }
                })
            }
        }
    }


    private fun setupAlertDialog(title: String, textHint: String,initData:String,editDialogCallback: EditDialog.EditDialogCallback) {
        val dialog = EditDialog(this,title,textHint,initData)
        dialog.setEditDialogCallback(editDialogCallback)
        dialog.show()
            }

    private fun showToastMessage(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}
*/
