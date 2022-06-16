package com.codingurkan.countryapiwithfragment.model

import java.io.Serializable

data class CountryItem(
    val capital: String? = null,
    val currency: String? = null,
    val flag: String? = null,
    val language: String? = null,
    val name: String? = null,
    val region: String? = null
):Serializable
