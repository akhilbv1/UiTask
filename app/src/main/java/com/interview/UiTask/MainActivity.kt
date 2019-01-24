package com.interview.UiTask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val homeList:MutableList<HomePojo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prepareData()
        val rvHome:RecyclerView = findViewById(R.id.rvHome)
        val layoutManager = LinearLayoutManager(this)
        rvHome.layoutManager = layoutManager
        rvHome.adapter = RecylerViewAdapter(homeList = homeList)
    }

    fun prepareData(){
        val homeSuggestionData1 = HomePojo(suggestionPojo = SuggestionPojo("Pista House",30,"25","3","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHrvnv0W-aPwV9b7GdU1c_BoD2zqfE8UfL06T7USNlpFSFNcf-",true),type = Constants.ROW_TYPE_SUGGESTION)
        homeList.add(homeSuggestionData1)
        val homeOffersData1 = HomePojo(offersPojo = OffersPojo("BUY ONE ITEM AND GET ONE ITEM FREE","FOR ONLY PREMIUM MEMBERS","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHrvnv0W-aPwV9b7GdU1c_BoD2zqfE8UfL06T7USNlpFSFNcf-",Constants.OFFER_TYPE_HOT),type = Constants.ROW_TYPE_OFFERS)
        homeList.add(homeOffersData1)
        val homeSuggestionData2 = HomePojo(suggestionPojo = SuggestionPojo("Pista House",30,"25","3","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHrvnv0W-aPwV9b7GdU1c_BoD2zqfE8UfL06T7USNlpFSFNcf-",true),type = Constants.ROW_TYPE_SUGGESTION)
        homeList.add(homeSuggestionData2)
        val homeOffersData2 = HomePojo(offersPojo = OffersPojo("BUY ONE ITEM AND GET ONE ITEM FREE","FOR ONLY PREMIUM MEMBERS","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHrvnv0W-aPwV9b7GdU1c_BoD2zqfE8UfL06T7USNlpFSFNcf-",Constants.OFFER_TYPE_HOT),type = Constants.ROW_TYPE_OFFERS)
        homeList.add(homeOffersData2)

    }
}
