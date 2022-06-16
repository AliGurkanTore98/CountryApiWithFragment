package com.codingurkan.countryapiwithfragment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import com.codingurkan.countryapiwithfragment.R
import com.codingurkan.countryapiwithfragment.databinding.FragmentInformationBinding
import com.codingurkan.countryapiwithfragment.databinding.FragmentInformationDetailsBinding
import com.codingurkan.countryapiwithfragment.model.CountryItem
import com.codingurkan.countryapiwithfragment.util.loadImage
import com.codingurkan.countryapiwithfragment.viewmodel.InformationDetailsViewModel


class InformationDetailsFragment : Fragment() {

    private var binding : FragmentInformationDetailsBinding? = null
    private var viewModel : InformationDetailsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInformationDetailsBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
       // getArgss()
        initObserver()
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this)[InformationDetailsViewModel::class.java]
    }

    private fun initObserver(){
        viewModel?.currentData?.observe(viewLifecycleOwner){
            binding?.imageFlag?.loadImage(it.flag!!)
        }
    }

    private fun getArgss(){
        this.arguments?.let {
            val datas = it.getSerializable("data")
            viewModel?.currentData?.value = datas as CountryItem
        }
    }
}