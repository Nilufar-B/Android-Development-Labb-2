package com.example.labb_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.labb_2.databinding.FragmentAboutBinding
import com.example.labb_2.databinding.FragmentMainBinding


class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null //can be NULL
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        val btnHome = binding.btnHomeAbout

        btnHome.setOnClickListener(){
            view -> view.findNavController().navigate(R.id.action_global_mainFragment)
        }

        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}