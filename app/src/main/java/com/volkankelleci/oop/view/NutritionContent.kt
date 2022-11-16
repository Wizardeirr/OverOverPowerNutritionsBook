package com.volkankelleci.oop.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.volkankelleci.oop.R
import com.volkankelleci.oop.viewmodel.NutritionContentViewModel
import kotlinx.android.synthetic.main.fragment_nutrition_content.*

class NutritionContent : Fragment() {
    private lateinit var viewModel: NutritionContentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nutrition_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel= ViewModelProvider(this)[NutritionContentViewModel::class.java]
        viewModel.roomVersionTake()

        observeLiveData()
    }

    fun observeLiveData(){

        viewModel.nutritionData.observe(viewLifecycleOwner, Observer{
            it?.let {
                besinismi.text=it.nutritionName
                karbonhidratmiktari.text=it.nutritionCarbonhydrate
                proteinmiktari.text=it.nutritionProtein
                kaloriismi.text=it.nutritionkcal
                yagmiktari.text=it.nutritionFat

            }
        })
    }

}