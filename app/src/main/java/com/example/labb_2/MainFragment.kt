package com.example.labb_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.Navigation
import com.example.labb_2.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null //can be NULL
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        val btnAboutPage = binding.btnAboutPage
        val btnTimerPage = binding.btnTimerPage
        val tvRegister = binding.tvRegister

        btnAboutPage.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_aboutFragment)
        }

        btnTimerPage.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_timerFragment)
        }

        tvRegister.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_registerFragment)
        }


        return view
    }



}




