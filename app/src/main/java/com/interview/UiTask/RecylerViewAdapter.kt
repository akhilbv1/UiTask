package com.interview.UiTask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecylerViewAdapter(val homeList:List<HomePojo>) : RecyclerView.Adapter<RecylerViewAdapter.ViewHolder>() {

    private var viewPool:RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_home, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      private val rvHomeList:RecyclerView = itemView.findViewById(R.id.rvHomeList)
        private
        fun updateUi(){
            rvHomeList.apply {
                layoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)
                adapter = NestedRecyclerViewAdapter(homeList)
            }
            rvHomeList.setRecycledViewPool(viewPool)
        }
    }
}