package com.example.labb_2.timer

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.concurrent.TimeUnit

class TimerViewModel: ViewModel() {

    private val _countdownState = MutableStateFlow(1500L)
    val countdownState: StateFlow<Long> = _countdownState
    private val initialTime = 25L //Initial time in minutes
    private var countdownJob: Job? = null

     fun startCountdown(){

     countdownJob = CoroutineScope(Dispatchers.Default).launch {
                 val initialTimeInSeconds = TimeUnit.MINUTES.toSeconds(initialTime)
                 for (i in initialTimeInSeconds downTo 0){
                     _countdownState.emit(i)
                     delay(1000)
                 }
             }
    }

    fun stopCountdown() {
        countdownJob?.cancel()
    }
}




