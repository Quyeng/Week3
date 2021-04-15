package com.example.w2_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.profile.view.*
import androidx.lifecycle.ViewModelProvider
import com.example.w2_challenge.databinding.ProfileBinding
import kotlinx.android.synthetic.main.dialog.*


class   Profile : AppCompatActivity() {
    private lateinit var viewmodel: ProfileViewModel
    private lateinit var binding:ProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.profile)

        findViewsById()
    }

    private fun findViewsById() {
        viewmodel = ViewModelProvider(this).get(ProfileViewModel::class.java)

    }

       /*private fun setupAlertDialog(title: String, textHint: String, textView: TextView) {
        val view: View = LayoutInflater
            .from(this)
            .inflate(R.layout.dialog, null, false)
        edtData = view.findViewById(R.id.edtdulieu)
        edtData.setText(textView.text)
        edtData.hint = textHint
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setView(view)
            .setTitle(title)
            .setPositiveButton("OK") { dialog, _ ->
                textView.text = edtData.text
                showToastMessage(edtData.text.toString())
                dialog.dismiss()
            }
            .setNegativeButton("CANCEL") { dialog, _ ->
                dialog.dismiss()
            }.show()

    }*/
       private fun setupAlertDialog(title: String, textHint: String, textView: TextView) {
               binding = DataBindingUtil.inflate(
                   LayoutInflater.from(),
                   R.layout.dialog,
                   null,
                   false
               )
               setContentView(binding.root)


               binding.apply {
                   til_base.text = title
                  edtdulieu.setText()
                   edtdulieu.hint = hint
                   btnCancel.setOnClickListener {
                       dismiss()
                   }
                   btnConfirm.setOnClickListener {
                       editDialogCallback.onConfirmClicked(edtdulieu.text.toString())
                       dismiss()
                   }
               }
           }

           fun setEditDialogCallback(editDialogCallback: EditDialogCallback) {
               this.editDialogCallback = editDialogCallback
           }

           interface EditDialogCallback {
               fun onConfirmClicked(data: String)
           }
       }

    private fun editInfo() {
        tvFullName.setOnClickListener {
            setupAlertDialog("Edit full name", "Enter your full name", tvFullName)
        }

        tvEmail.setOnClickListener {
            setupAlertDialog("Edit e-mail ", "Enter your e-mail", tvEmail)
        }

        tvPhoneNumber.setOnClickListener {
            setupAlertDialog("Edit phone number ", "Enter your phone number", tvPhoneNumber)
        }
    }

    private fun showToastMessage(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}