package com.codingurkan.countryapiwithfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingurkan.countryapiwithfragment.databinding.RecyclerRowBinding
import com.codingurkan.countryapiwithfragment.model.CountryItem
import com.codingurkan.countryapiwithfragment.util.loadImage

class CountryInformationAdapter(private val list : ArrayList<CountryItem>,
                                private val itemClickListener : ItemClickListener )   : RecyclerView.Adapter<CountryInformationAdapter.CountryVH>() {

    inner class CountryVH(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryVH {
        val view = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CountryVH(view)
    }
    override fun onBindViewHolder(holder: CountryVH, position: Int) {
        with(holder.binding){
            imageFlag.loadImage(list[position].flag!!)
            countryName.text = list[position].name
            countryCapital.text = list[position].capital
            textRegion.text  = list[position].region
            currency.text = list[position].currency
            countryLanguage.text = list[position].language

            imageFlag.setOnClickListener {
                itemClickListener.onclick(list[position])
            }
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }

    interface ItemClickListener{
        fun onclick(data : CountryItem)
    }
}