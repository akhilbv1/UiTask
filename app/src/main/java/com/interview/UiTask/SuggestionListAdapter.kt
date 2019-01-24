package com.interview.UiTask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_item_suggestion.view.*

class SuggestionListAdapter(val homeList: List<SuggestionPojo>) : RecyclerView.Adapter<SuggestionListAdapter.SuggestionsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionListAdapter.SuggestionsViewHolder {
           val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_suggestion, parent, false)
            return SuggestionsViewHolder(view)
    }


    override fun getItemCount(): Int {
        return homeList.size
    }

    override fun onBindViewHolder(holder: SuggestionListAdapter.SuggestionsViewHolder, position: Int) {
            holder.updateRowItemSuggestion(position)
    }

    inner class SuggestionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var suggestionPojo: SuggestionPojo
        val tvBestSeller: TextView = itemView.findViewById(R.id.tvBestSeller)

        val tvRestName: TextView = itemView.findViewById(R.id.tvRestName)

        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)

        val tvTime: TextView = itemView.findViewById(R.id.tvTime)

        val tvRatings: TextView = itemView.findViewById(R.id.tvRating)

        val ivFoodLogo: ImageView = itemView.findViewById(R.id.ivFoodLogo)


        fun updateRowItemSuggestion(position: Int) {
            suggestionPojo = homeList[position]

            itemView.tvFoodTitle.text = suggestionPojo.foodName

            tvRestName.text = suggestionPojo.restName

            if (suggestionPojo.isBestSeller) tvBestSeller.visibility = View.VISIBLE
            else tvBestSeller.visibility = View.GONE

            tvTime.text = "${suggestionPojo.delTime} mins"

            tvRatings.text = suggestionPojo.rating

            tvPrice.text = itemView.context.getString(R.string.rupee_symbol) + " ${suggestionPojo.price} per piece"

            Glide.with(itemView.context).load(suggestionPojo.foodLogo).into(ivFoodLogo)
        }
    }

}