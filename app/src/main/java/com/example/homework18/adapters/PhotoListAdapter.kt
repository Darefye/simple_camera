package com.example.homework18.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.homework18.data.entity.Photo
import com.example.homework18.databinding.PhotoItemBinding

class PhotoListAdapter : RecyclerView.Adapter<PhotoViewHolder>() {


    private var data: List<Photo> = emptyList()

    fun setData(data: List<Photo>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            PhotoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = data.getOrNull(position)
        with(holder.binding) {
            item?.let {
                date.text = it.date
                Glide
                    .with(photo.context)
                    .load(it.uri)
                    .centerCrop()
                    .into(photo)
            }
        }
    }
}

class PhotoViewHolder(val binding: PhotoItemBinding) : ViewHolder(binding.root)