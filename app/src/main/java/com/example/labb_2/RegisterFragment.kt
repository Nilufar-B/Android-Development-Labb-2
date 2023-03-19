package com.example.labb_2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.labb_2.databinding.FragmentMainBinding
import com.example.labb_2.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar

class RegisterEmail ( val email: String)

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        val tiEmail = binding.tiEmail
        val btnRegister = binding.btnRegister
        val btnHome = binding.btnHome


        var emails = ArrayList<RegisterEmail>()

        btnRegister.setOnClickListener(){

            val email: String = tiEmail.text.toString()

            if (email.isNotEmpty()){
                emails.add(RegisterEmail(email))
                println("Email is $email")

                Snackbar.make(tiEmail, "New email register", Snackbar.LENGTH_LONG).
                setAction("UNDO"){
                    if (email.isNotEmpty()){
                        emails.remove(RegisterEmail(email))
                        Snackbar.make(tiEmail,"Email removed!", Snackbar.LENGTH_LONG).show()
                        println("Email removed!")
                    }else{
                        println("Try again.")
                    }
                }.show()
            } else{
                Snackbar.make(tiEmail, "Please enter e-mail.", Snackbar.LENGTH_LONG).show()

            }

        }

        btnHome.setOnClickListener(){
            view -> view.findNavController().navigate(R.id.action_global_mainFragment)
        }



        return view
    }

}