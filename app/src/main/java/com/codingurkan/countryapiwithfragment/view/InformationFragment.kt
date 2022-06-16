package com.codingurkan.countryapiwithfragment.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingurkan.countryapiwithfragment.R
import com.codingurkan.countryapiwithfragment.adapter.CountryInformationAdapter
import com.codingurkan.countryapiwithfragment.databinding.FragmentInformationBinding
import com.codingurkan.countryapiwithfragment.model.CountryItem
import com.codingurkan.countryapiwithfragment.util.showMessage
import com.codingurkan.countryapiwithfragment.viewmodel.InformationViewModel


class InformationFragment : Fragment() {

    private var binding: FragmentInformationBinding? = null
    private var viewModel : InformationViewModel? = null
    private var adapter : CountryInformationAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ? {
        binding = FragmentInformationBinding.inflate(layoutInflater)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            initViewModel()
            initObserver()
            viewModel?.downloadData()
    }
    private fun initViewModel(){
        viewModel = ViewModelProvider(this)[InformationViewModel::class.java]
    }
    private fun initObserver(){
        viewModel?.informationList?.observe(viewLifecycleOwner){
            initAdapter(it)
        }
    }
    private fun initAdapter(data : ArrayList<CountryItem>){
        adapter = CountryInformationAdapter(data , object : CountryInformationAdapter.ItemClickListener{
            override fun onclick(data: CountryItem) {
              //  otherFragment(data)
            }
        })
        binding?.apply {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(activity?.baseContext)
        }
    }
    /*
    private fun navigateToOtherFragment(data : CountryItem) {
        val fT = fragmentManager?.beginTransaction()
        val bundle = Bundle().apply {
            putSerializable("data",data)
        }
        val infoFragment = InformationDetailsFragment()
        infoFragment.arguments = bundle
        fT?.replace(R.id.nav_graph,infoFragment)?.commit()
    }


    private fun otherFragment(data : CountryItem){

        val bundle = Bundle()
        val fragment = InformationDetailsFragment()
        bundle.putSerializable("data",data)
        fragment.arguments = bundle
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.informationFragment,InformationDetailsFragment())
            commit()
        }
    }
    
     */
}