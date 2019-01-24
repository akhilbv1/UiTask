package com.interview.UiTask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NestedRecyclerViewAdapter(val homeList: List<HomePojo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        if (viewType == Constants.ROW_TYPE_SUGGESTION) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_suggestion, parent, false)
            return SuggestionsViewHolder(view)
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_offers, parent, false)
            return OffersViewHolder(view)
        }
    }


    override fun getItemViewType(position: Int): Int {

        return homeList[position].type

    }

    override fun getItemCount(): Int {
        return homeList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SuggestionsViewHolder) {
            holder.updateRowItemSuggestion(position)
        } else if (holder is OffersViewHolder) {
            holder.updateRowItemOffers(position)
        }
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
            suggestionPojo = homeList[position].suggestionPojo

            tvRestName.text = suggestionPojo.restName

            if (suggestionPojo.isBestSeller) tvBestSeller.visibility = View.VISIBLE
            else tvBestSeller.visibility = View.GONE

            tvTime.text = "${suggestionPojo.delTime} mins"

            tvRatings.text = suggestionPojo.rating

            tvPrice.text = itemView.context.getString(R.string.rupee_symbol) + " ${suggestionPojo.price} per piece"

            Glide.with(itemView.context).load(suggestionPojo.foodLogo).into(ivFoodLogo)
        }
    }

    inner class OffersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val flOffer: FrameLayout = itemView.findViewById(R.id.flOffer)

        val ivofferLogo: ImageView = itemView.findViewById(R.id.ivOfferLogo)

        val ivHot: TextView = itemView.findViewById(R.id.ivHot)

        val tvSpecial: TextView = itemView.findViewById(R.id.tvSpecial)

        val tvOfferTitle: TextView = itemView.findViewById(R.id.tvOfferTitle)

        val tvOfferDes: TextView = itemView.findViewById(R.id.tvOfferDescription)

        lateinit var offersPojo: OffersPojo

        fun updateRowItemOffers(position: Int) {
            offersPojo = homeList[position].offersPojo

            if (offersPojo.offerType == Constants.OFFER_TYPE_HOT) {
                flOffer.setBackgroundResource(R.drawable.red_frame)
                ivHot.visibility = View.VISIBLE
                tvSpecial.visibility = View.GONE
            } else {
                flOffer.setBackgroundResource(R.drawable.blue_frame)
                ivHot.visibility = View.GONE
                tvSpecial.visibility == View.VISIBLE
            }
            Glide.with(itemView.context).load(offersPojo.offerLogo).into(ivofferLogo)

            tvOfferTitle.text = offersPojo.offerTitle
            tvOfferDes.text = offersPojo.offerDescription
        }
    }


}