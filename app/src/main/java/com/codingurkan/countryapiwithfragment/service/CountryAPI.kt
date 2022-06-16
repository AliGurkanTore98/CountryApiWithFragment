package com.codingurkan.countryapiwithfragment.service

import com.codingurkan.countryapiwithfragment.model.CountryItem
import retrofit2.Response
import retrofit2.http.GET

interface CountryAPI {

    @GET("/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")

   suspend fun getInformation() : Response<ArrayList<CountryItem>>

   @GET("details")
   suspend fun getInformationDetails() : Response<CountryItem>
}