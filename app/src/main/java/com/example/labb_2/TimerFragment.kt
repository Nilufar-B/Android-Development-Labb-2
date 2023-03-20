package com.example.labb_2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import com.example.labb_2.databinding.FragmentTimerBinding
import com.example.labb_2.timer.TimerViewModel
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit



class TimerFragment : Fragment() {

    private var _binding: FragmentTimerBinding? = null //can be NULL
    private val binding get() = _binding!!

    private val timerViewModel by viewModels<TimerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    @SuppressLint("SuspiciousIndentation", "UnsafeRepeatOnLifecycleDetector", "SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTimerBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        val btnHome = binding.btnHomeTimer
        val timer = binding.tvTimer
        val btnStart = binding.btnStartButton
        val btnStop = binding.btnStopButton

        lifecycleScope.launchWhenCreated {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                timerViewModel.countdownState.collect{countdownValue ->

                    val remainingMinutes = TimeUnit.SECONDS.toMinutes(countdownValue)
                    val remainingSeconds = countdownValue % 60
                    timer.text = "${remainingMinutes}:${remainingSeconds}"

                }
            }
        }
        btnStart.setOnClickListener(){
            timerViewModel.startCountdown()
        }

        btnStop.setOnClickListener(){
             timerViewModel.stopCountdown()
        }


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


