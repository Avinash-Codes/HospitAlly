package com.example.hospitally.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HospitalInfo:ViewModel() {
    var hospitalName by mutableStateOf("")
    var hospitalAddress by mutableStateOf("")
    var hospitalRegistrationNumber by mutableStateOf("")
    var hospitalContactNumber by mutableStateOf("")
    var hospitalEmail by mutableStateOf("")
    var hospitalWebsite by mutableStateOf("")
    var hospitalPassword by mutableStateOf("")

    var staffName by mutableStateOf("")
    var staffId by mutableStateOf("")
    var staffEmail by mutableStateOf("")
    var staffPassword by mutableStateOf("")
    var staffContactNumber by mutableStateOf("")
    var staffDesignation by mutableStateOf("")

    var selectedCardIndex by   mutableIntStateOf(-1)


}




