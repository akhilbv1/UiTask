package com.interview.UiTask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvHome:RecyclerView = findViewById(R.id.rvHome)
        val layoutManager = LinearLayoutManager(this)
        rvHome.layoutManager = layoutManager
        rvHome.adapter = RecylerViewAdapter()
    }
}
