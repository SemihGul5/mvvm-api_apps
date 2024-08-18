package com.example.gotapiapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels// viewmodels importu
import com.example.gotapiapp.R
import com.example.gotapiapp.databinding.FragmentAnasayfaBinding
import com.example.gotapiapp.ui.adapter.KarakterAdapter
import com.example.gotapiapp.ui.viewmodel.AnasayfaViewModel

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=FragmentAnasayfaBinding.inflate(inflater, container, false)

        viewModel.karakters.observe(viewLifecycleOwner){
            val karakterAdapter=KarakterAdapter(requireContext(),it)
            binding.anasayfaRv.adapter=karakterAdapter
        }







        return binding.root
    }



}