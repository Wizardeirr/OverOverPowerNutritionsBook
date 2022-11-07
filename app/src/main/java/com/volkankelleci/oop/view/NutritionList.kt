package com.volkankelleci.oop   .view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.volkankelleci.oop.Adapter.NutritionRecyclerAdapter
import com.volkankelleci.oop.R
import com.volkankelleci.oop.model.nutrition
import com.volkankelleci.oop.viewmodel.nutritionsViewModel
import kotlinx.android.synthetic.main.fragment_nutrition_list.*

class NutritionList : Fragment() {

    private lateinit var viewModel:nutritionsViewModel
    private val recycler1 = NutritionRecyclerAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return inflater.inflate(R.layout.fragment_nutrition_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=ViewModelProvider(this).get(nutritionsViewModel::class.java)
        viewModel.refreshData()

        recyclerView.layoutManager=LinearLayoutManager(context)
        recyclerView.adapter=recycler1



    }
    fun observeLiveData(){
        viewModel.nutritions.observe(this,Observer{
            it?.let {
                recyclerView.visibility=View.VISIBLE
                recycler1.updateToNewNutritionList(it)
            }
        })
        viewModel.errorMessage.observe(this,Observer{
            it?.let {
                if(it==true){
                    errorTextView.visibility=View.VISIBLE
                }else{
                    errorTextView.visibility=View.GONE
                }
            }
        })
        viewModel.progressBar.observe(this,Observer{
            it?.let {
                if (it==true){
                    recyclerView.visibility=View.GONE
                    errorTextView.visibility=View.GONE
                    progressBar.visibility=View.VISIBLE
                }else{
                    progressBar.visibility=View.GONE
                }
            }
        })
    }



}