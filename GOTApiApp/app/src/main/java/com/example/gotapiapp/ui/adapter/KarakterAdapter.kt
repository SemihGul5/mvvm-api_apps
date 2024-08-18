package com.example.gotapiapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gotapiapp.data.model.Karakter
import com.example.gotapiapp.databinding.CardTasarimBinding
import com.example.gotapiapp.databinding.FragmentAnasayfaBinding
import com.example.gotapiapp.ui.fragment.AnasayfaFragmentDirections
import com.example.gotapiapp.ui.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class KarakterAdapter(var mContext: Context,var karakters:List<Karakter>):RecyclerView.Adapter<KarakterAdapter.CardTasarimHolder>() {


    inner class CardTasarimHolder(var binding:CardTasarimBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        var binding= CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimHolder(binding)
    }

    override fun getItemCount(): Int {
        return karakters.size
    }

    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val karakter=karakters.get(position)
        var bindig=holder.binding
        Glide.with(mContext).load(karakter.imageUrl).override(500,750).into(bindig.imageViewCardCharacterImage)
        bindig.textViewCharacterName.text=karakter.fullName
        bindig.textViewFamily.text=karakter.family
        bindig.textViewTitle.text=karakter.title

        bindig.etkinlikCard.setOnClickListener {
            var gecis=AnasayfaFragmentDirections.actionAnasayfaFragmentToDetayFragment(karakter)
            Navigation.gecisYap(it,gecis)
        }

        Log.e("detay",
            "family: ${karakter.family},\n id:${karakter.id},\n" +
                " title:${karakter.title},\n" +
                " firstname:${karakter.firstName},\n" +
                " lastname:${karakter.lastName},\n" +
                " fullname:${karakter.fullName},\n" +
                " image:${karakter.image},\n" +
                " imageurl:${karakter.imageUrl}")
    }
}