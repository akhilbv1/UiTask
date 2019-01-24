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
        rvHome.adapter = HomeListAdapter(homeList = homeList)
    }

    /**
     * preparing mock data
     */
    fun prepareData(){
        val suggestionsList:MutableList<SuggestionPojo>? = ArrayList()
        suggestionsList?.add(SuggestionPojo("Hot Samosas with chutneys","Pista House",30,"25","3","http://www.cooktube.in/wp-content/uploads/2016/11/Aloo-Samosa-1.jpg",true))
        suggestionsList?.add(SuggestionPojo("Mutton Biryani","Pista House",20,"25","3","https://i1.wp.com/media.hungryforever.com/wp-content/uploads/2017/09/02105930/lucknowi-mutton-biryani-recipe.jpg?ssl=1?w=356&strip=all&quality=80",true))
        suggestionsList?.add(SuggestionPojo("Veg Noodles","Xian Shang",40,"80","5","https://www.seriouseats.com/recipes/images/2015/05/20150424-singapore-noodles-shao-zhong-20-1500x1125.jpg",false))

        val offersList:MutableList<OffersPojo>? = ArrayList()
        offersList?.add(OffersPojo("BUY ONE ITEM AND GET ONE ITEM FREE","FOR ONLY PREMIUM MEMBERS","https://lookandcook.com/wp-content/uploads/2014/10/LC14026-main1.jpg",Constants.OFFER_TYPE_HOT))
        offersList?.add(OffersPojo("50% CASHBACK","FOR ONLY PREMIUM MEMBERS","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHrvnv0W-aPwV9b7GdU1c_BoD2zqfE8UfL06T7USNlpFSFNcf-",Constants.OFFER_TYPE_SPECIAL))
        offersList?.add(OffersPojo("VEG FRIED RICE FREE","PAYING THROUGH PAYTM","https://eatstudio.in/wp-content/uploads/2018/05/veg-fried-rice.jpg",Constants.OFFER_TYPE_HOT))

        val homeSuggestionData1 = HomePojo(suggestionPojo = suggestionsList,type = Constants.ROW_TYPE_SUGGESTION)
        homeList.add(homeSuggestionData1)

        val homeOffersData1 = HomePojo(offerss = offersList ,type = Constants.ROW_TYPE_OFFERS)
        homeList.add(homeOffersData1)

        val homeSuggestionData2 = HomePojo(suggestionPojo = suggestionsList,type = Constants.ROW_TYPE_SUGGESTION)
        homeList.add(homeSuggestionData2)

        val homeOffersData2 = HomePojo(offerss = offersList,type = Constants.ROW_TYPE_OFFERS)
        homeList.add(homeOffersData2)

    }
}
