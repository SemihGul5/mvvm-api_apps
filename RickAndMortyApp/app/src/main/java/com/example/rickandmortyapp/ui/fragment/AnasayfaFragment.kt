package com.example.rickandmortyapp.ui.fragment

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.FragmentAnasayfaBinding
import com.example.rickandmortyapp.ui.adapter.CharacterAdapter
import com.example.rickandmortyapp.ui.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        val iVarmi = viewModel.isNetworkAvailable(requireContext())
        if (!iVarmi) {
            Toast.makeText(requireContext(), "İnternet Bağlantısı Yok!", Toast.LENGTH_SHORT).show()
        } else {
            binding.toolbarAnasayfa.title = "Rick And Morty Characters"
            viewModel.karakters.observe(viewLifecycleOwner) {
                val karakterAdapter = CharacterAdapter(requireContext(), it)
                binding.anasayfaRv.adapter = karakterAdapter
            }
        }

        return binding.root
    }
}
