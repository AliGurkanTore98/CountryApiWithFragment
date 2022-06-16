package com.codingurkan.countryapiwithfragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codingurkan.countryapiwithfragment.model.CountryItem

class InformationDetailsViewModel : ViewModel() {

    val currentData = MutableLiveData<CountryItem>()
}