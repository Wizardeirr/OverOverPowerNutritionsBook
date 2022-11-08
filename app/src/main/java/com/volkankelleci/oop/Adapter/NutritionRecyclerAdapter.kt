package com.volkankelleci.oop.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.volkankelleci.oop.R
import com.volkankelleci.oop.model.nutrition
import com.volkankelleci.oop.view.NutritionContentDirections
import com.volkankelleci.oop.view.NutritionListDirections
import kotlinx.android.synthetic.main.nutrition_recycler_row.view.*

class NutritionRecyclerAdapter(val nutritionList:ArrayList<nutrition>): RecyclerView.Adapter<NutritionRecyclerAdapter.nutritionVH>() {
    class nutritionVH(itemView:View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): nutritionVH {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.nutrition_recycler_row,parent,false)
        return nutritionVH(view)
    }

    override fun onBindViewHolder(holder: nutritionVH, position: Int) {
        holder.itemView.nutritionname.text=nutritionList.get(position).nutritionName
        holder.itemView.nutritionkcal.text=nutritionList.get(position).nutritionkcal

        holder.itemView.setOnClickListener{
            val action=NutritionListDirections.listToContent(0)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return nutritionList.size
    }
    fun updateToNewNutritionList(newNutritionList:List<nutrition>){
        nutritionList.clear()
        nutritionList.addAll(newNutritionList)
        notifyDataSetChanged()
    }
}