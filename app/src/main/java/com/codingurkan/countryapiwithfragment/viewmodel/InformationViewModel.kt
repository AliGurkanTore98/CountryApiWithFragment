package com.codingurkan.countryapiwithfragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingurkan.countryapiwithfragment.model.CountryItem
import com.codingurkan.countryapiwithfragment.service.ApiClient
import com.codingurkan.countryapiwithfragment.service.CountryAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InformationViewModel : ViewModel() {

    private var job : Job? = null
    val informationList = MutableLiveData<ArrayList<CountryItem>>()
    private val apiClient = ApiClient.getClient().create(CountryAPI::class.java)


    fun downloadData(){

        job = viewModelScope.launch(context = Dispatchers.IO){
            val response =apiClient.getInformation()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    response.body()?.let {
                        informationList.value = it
                    }
                }
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}