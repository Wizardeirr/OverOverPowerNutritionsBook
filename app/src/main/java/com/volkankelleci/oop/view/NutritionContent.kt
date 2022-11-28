package com.volkankelleci.oop.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.volkankelleci.oop.R
import com.volkankelleci.oop.Util.gorselIndır
import com.volkankelleci.oop.Util.placeHolderYap
import com.volkankelleci.oop.viewmodel.NutritionContentViewModel
import kotlinx.android.synthetic.main.fragment_nutrition_content.*
import kotlinx.android.synthetic.main.nutrition_recycler_row.*

class NutritionContent : Fragment() {
    private lateinit var viewModel: NutritionContentViewModel
    private var besinID=0
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
        arguments?.let {
            besinID=NutritionContentArgs.fromBundle(it).besinID
        }

        viewModel= ViewModelProvider(this)[NutritionContentViewModel::class.java]
        viewModel.roomVersionTake(besinID)

        observeLiveData()
    }

    fun observeLiveData(){

        viewModel.nutritionData.observe(viewLifecycleOwner, Observer{
            it?.let {
                besinismi.text=it.isim
                karbonhidratmiktari.text=it.karbonhidrat
                proteinmiktari.text=it.protein
                kaloriismi.text=it.kalori
                yagmiktari.text=it.yag
                resim.gorselIndır(it.gorsel, placeHolderYap(requireContext()))

            }
        })
    }

}