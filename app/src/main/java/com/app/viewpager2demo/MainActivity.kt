package com.app.viewpager2demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.viewpager2demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityMainBinding.root
        setContentView(view)
        initViewPagerData()
    }

    private fun initViewPagerData() {
        val imagesList: ArrayList<Int> = ArrayList()
        imagesList.add(R.drawable.image1)
        imagesList.add(R.drawable.image2)
        imagesList.add(R.drawable.image3)
        imagesList.add(R.drawable.image4)
        imagesList.add(R.drawable.image5)

        activityMainBinding.viewpager2.adapter =
            ImageViewPagerAdapter(this@MainActivity, imagesList)
        activityMainBinding.indicator.setViewPager(activityMainBinding.viewpager2)
    }

}