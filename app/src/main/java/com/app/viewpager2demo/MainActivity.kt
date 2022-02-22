package com.app.viewpager2demo

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette
import androidx.palette.graphics.Palette.Swatch
import androidx.viewpager2.widget.ViewPager2
import com.app.viewpager2demo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var activityMainBinding: ActivityMainBinding
    private val imagesList: ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityMainBinding.root
        setContentView(view)
        initViewPagerData()

        activityMainBinding.viewpager2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                selectColors(imagesList[position])
            }
        })
    }

    fun selectColors(image: Int) {
        val bitmap = BitmapFactory.decodeResource(resources, image)
        Palette.from(bitmap).generate { p ->
            val defaultValue = 0x000000
            val vibrant: Swatch? = p?.vibrantSwatch
            activityMainBinding.imageView.setColorFilter(p!!.getLightVibrantColor(defaultValue))
//            activityMainBinding.clMain.setBackgroundColor(vibrant?.bodyTextColor!!)
            activityMainBinding.clMain.setBackgroundColor(p.getDarkVibrantColor(defaultValue))
//            activityMainBinding.imageView.setColorFilter(vibrant!!.bodyTextColor)
//            activityMainBinding.imageView.setColorFilter(vibrant!!.titleTextColor)
//            activityMainBinding.imageView.setColorFilter(vibrant!!.rgb)
            /*
            activityMainBinding.imageView.setColorFilter(p!!.getDominantColor(defaultValue))
            activityMainBinding.imageView.setColorFilter(p!!.getLightVibrantColor(defaultValue))
            activityMainBinding.imageView.setColorFilter(p!!.getLightMutedColor(defaultValue))*/
        }
    }

    private fun initViewPagerData() {
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