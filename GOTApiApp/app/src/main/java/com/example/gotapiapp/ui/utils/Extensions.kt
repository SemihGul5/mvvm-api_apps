package com.example.gotapiapp.ui.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import java.util.Objects

fun Navigation.gecisYap(view:View,navDirections: NavDirections){
    findNavController(view).navigate(navDirections)
}

fun Navigation.gecisYap(view:View,id:Int){
    findNavController(view).navigate(id)
}
