package com.interview.UiTask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item_home.view.*

class HomeListAdapter(val homeList: List<HomePojo>) : RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_home, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.updateUi(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public fun updateUi(position: Int) {
            if (homeList[position].type == Constants.ROW_TYPE_OFFERS) {
                itemView.tvHeader.text = "Ongoing offers"
                itemView.rvHorizontalList.adapter = OffersListAdapter(homeList[position].offerss!!)
                itemView.rvHorizontalList.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)

            } else {
                itemView.tvHeader.text = "We suggest you order these"
                itemView.rvHorizontalList.adapter = SuggestionListAdapter(homeList[position].suggestionPojo!!)
                itemView.rvHorizontalList.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }
}