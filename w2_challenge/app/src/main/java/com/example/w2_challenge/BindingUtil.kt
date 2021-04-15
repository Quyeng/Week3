package com.example.w2_challenge

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("paddingHorizontal")
fun setHorizontalPadding(view : View, padding : Int){
    view.setPadding(padding, view.paddingTop, padding, view.paddingBottom)
}

@BindingAdapter("paddingVertical")
fun setVerticalPadding(view : View, padding : Int){
    view.setPadding(view.paddingLeft, padding , view.paddingRight, padding)
}