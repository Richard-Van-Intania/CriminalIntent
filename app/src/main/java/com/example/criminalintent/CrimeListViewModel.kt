package com.example.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import java.util.*
import kotlinx.coroutines.launch

private const val TAG = "CrimeListViewModel"

class CrimeListViewModel : ViewModel() {
  private val crimeRepository = CrimeRepository.get()
  val crimes = crimeRepository.getCrimes()
  init {
    viewModelScope.launch {}
  }
}
