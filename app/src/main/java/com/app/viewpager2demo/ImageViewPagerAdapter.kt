package com.app.viewpager2demo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.viewpager2demo.ImageViewPagerAdapter.ViewPagerViewHolder
import com.app.viewpager2demo.databinding.ImageItemLayoutBinding
import com.bumptech.glide.Glide

class ImageViewPagerAdapter(var context: Context, var images: ArrayList<Int>) :
    RecyclerView.Adapter<ViewPagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding =
            ImageItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        Glide.with(context)
            .load(images[position])
            .placeholder(R.drawable.empty_placeholder)
            .error(R.drawable.empty_placeholder)
            .into(holder.imageItemLayoutBinding.image1)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ViewPagerViewHolder(val imageItemLayoutBinding: ImageItemLayoutBinding) :
        RecyclerView.ViewHolder(imageItemLayoutBinding.root)
}