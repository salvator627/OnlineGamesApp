package com.example.games

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions


class GameAdapter(private val list : ArrayList<PostResponse>): RecyclerView.Adapter<GameAdapter.ViewHolder>(){
    inner class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        fun bind(postResponse: PostResponse){
            with(itemView){
                val img = findViewById<ImageView>(R.id.imageView)
                Glide.with(itemView)
                    .load(postResponse.thumbnail)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(img)
                val text = findViewById<TextView>(R.id.textView)
                val dev = findViewById<TextView>(R.id.textView2)
                text.text = "${postResponse.title}"
                dev.text = "${postResponse.developer}"


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

    }
}