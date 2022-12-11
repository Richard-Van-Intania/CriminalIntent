package com.example.criminalintent

import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.random.Random

class CrimeListViewModel : ViewModel() {
  val crimes = mutableListOf<Crime>()
  init {
    for (i in 0 until 100) {
      val crime =
          Crime(
              id = UUID.randomUUID(),
              title = "Crime of #${i+1}",
              date = Date(),
              isSolved = Random.nextBoolean())
      crimes += crime
    }
  }
}
