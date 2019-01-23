package com.interview.UiTask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NestedRecyclerViewAdapter() : RecyclerView.Adapter<NestedRecyclerViewAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_suggestion,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}