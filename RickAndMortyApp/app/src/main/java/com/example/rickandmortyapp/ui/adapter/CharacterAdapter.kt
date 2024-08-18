package com.example.rickandmortyapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.databinding.CardTasarimBinding
import com.example.rickandmortyapp.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class CharacterAdapter(var mContext:Context,var karakters:List<Character>):RecyclerView.Adapter<CharacterAdapter.CardTasarimHolder>() {

    inner class CardTasarimHolder(var binding: CardTasarimBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        var  binding= CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimHolder(binding)
    }

    override fun getItemCount(): Int {
        return karakters.size
    }

    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        var karakter=karakters.get(position)
        val t = holder.binding

        val url=karakter.image
        Glide.with(mContext).load(url).override(500,750).into(t.imageViewCardCharacterImage)

        t.textViewCharacterName.text=karakter.name
        t.textViewLastLocation.text=karakter.location.name
        t.textViewCinsiyet.text=karakter.gender

        t.etkinlikCard.setOnClickListener {
            var gecis=AnasayfaFragmentDirections.actionAnasayfaFragmentToDetayFragment(karakter)
            Navigation.findNavController(it).navigate(gecis)
        }

    }


}