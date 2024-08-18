package com.example.gotapiapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

import com.example.gotapiapp.R
import com.example.gotapiapp.databinding.FragmentDetayBinding
import com.example.gotapiapp.ui.viewmodel.DetayViewModel


class DetayFragment : Fragment() {
    private lateinit var binding:FragmentDetayBinding
    private lateinit var viewModel:DetayViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=FragmentDetayBinding.inflate(inflater, container, false)

        val bundle=DetayFragmentArgs.fromBundle(requireArguments())
        val karakter=bundle.karakter
        Glide.with(requireContext()).load(karakter.imageUrl).into(binding.imageViewKarakterFoto)
        binding.karakterAd.text=karakter.fullName
        binding.textTitle.text=karakter.title
        binding.textFamily.text=karakter.family





        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetayViewModel by viewModels()
        viewModel = tempViewModel
    }
}