package com.easyjp.amap

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Map : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_map)
        val intent = this.intent
        val data = intent.data
        val slat = data?.getQueryParameter("slat")
        val slon = data?.getQueryParameter("slon")
        Log.d("From360", data.toString());
        val dlat = data?.getQueryParameter("dlat")
        val dlon = data?.getQueryParameter("dlon")

        val url = String.format("https://www.google.com/maps/search/?api=1&query=%s,%s", dlat,dlon)
        Log.d("From360", url);
        val mapUri = Uri.parse(String.format("geo:0,0?q=%s,%s", dlat, dlon))
        val gmap = Intent(Intent.ACTION_VIEW, mapUri)
        gmap.setPackage("com.google.android.apps.maps")
        startActivity(gmap)
        finish()
    }
}