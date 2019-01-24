package com.interview.UiTask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class OffersListAdapter(val offersList: List<OffersPojo>):RecyclerView.Adapter<OffersListAdapter.OffersViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_offers, parent, false)
        return OffersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return offersList.size
    }

    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
        holder.updateRowItemOffers(position)
    }

    inner class OffersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val flOffer: FrameLayout = itemView.findViewById(R.id.flOffer)

        val ivofferLogo: ImageView = itemView.findViewById(R.id.ivOfferLogo)

        val tvOfferTitle: TextView = itemView.findViewById(R.id.tvOfferTitle)

        val tvOfferDes: TextView = itemView.findViewById(R.id.tvOfferDescription)

        lateinit var offersPojo: OffersPojo

        fun updateRowItemOffers(position: Int) {
            offersPojo = offersList[position]

            if (offersPojo.offerType == Constants.OFFER_TYPE_HOT) {
                flOffer.setBackgroundResource(R.drawable.red_frame)
            } else if (offersPojo.offerType == Constants.OFFER_TYPE_SPECIAL){
                flOffer.setBackgroundResource(R.drawable.blue_frame)
            }
            Glide.with(itemView.context).load(offersPojo.offerLogo).into(ivofferLogo)

            tvOfferTitle.text = offersPojo.offerTitle
            tvOfferDes.text = offersPojo.offerDescription
        }
    }
}