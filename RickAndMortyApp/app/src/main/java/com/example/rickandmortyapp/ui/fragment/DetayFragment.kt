package com.example.rickandmortyapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.FragmentDetayBinding
import com.example.rickandmortyapp.ui.viewmodel.AnasayfaViewModel
import com.example.rickandmortyapp.ui.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding:FragmentDetayBinding
    private lateinit var viewModel:DetayViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding=FragmentDetayBinding.inflate(inflater, container, false)
        val bundle:DetayFragmentArgs by navArgs()
        val karakter=bundle.Character
        binding.materialToolbarDetay.title="Character Detail"

        Glide.with(requireContext()).load(karakter.image).into(binding.imageViewKarakterFoto)
        binding.karakterAd.text=karakter.name
        binding.cinsiyet.text=karakter.gender
        binding.textStatus.text=karakter.status
        binding.textSpecies.text=karakter.species
        binding.textType.text=karakter.type
        binding.textOrigin.text=karakter.origin.name
        binding.textLocation.text=karakter.location.name
        binding.textCreated.text=karakter.created






        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetayViewModel by viewModels()
        viewModel = tempViewModel
    }

}