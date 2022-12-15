package com.example.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import java.util.*
import kotlin.random.Random
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val TAG = "CrimeListViewModel"

class CrimeListViewModel : ViewModel() {

  val crimes = mutableListOf<Crime>()
  init {
    Log.d(TAG, "init starting")
    viewModelScope.launch {
      Log.d(TAG, "coroutine launched")
      crimes += loadCrimes()
      Log.d(TAG, "Loading crimes finished")
    }
  }

  suspend fun loadCrimes(): List<Crime> {
    val result = mutableListOf<Crime>()
    delay(5000)
    for (i in 0 until 200) {
      val crime =
          Crime(
              id = UUID.randomUUID(),
              title = "Crime of #${i+1}",
              date = Date(),
              isSolved = Random.nextBoolean())
      result += crime
    }
    return result
  }
}
