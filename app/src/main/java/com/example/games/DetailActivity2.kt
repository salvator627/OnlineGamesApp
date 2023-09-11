package com.example.games


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.games.databinding.ActivityDetail2Binding

class DetailActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityDetail2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<PostResponse>("data")
        if (data!=null){
            binding.textView3.text = data.title
            binding.tvDev.text = data.developer
            binding.tvDescription.text = data.short_description
            binding.tvPlatform.text = "Platform : ${data.platform}"
            binding.tvRelase.text = "Release Date : ${data.release_date}"
            binding.tvGenre.text = "Genre : ${data.genre}"
            binding.apply {
                Glide.with(this@DetailActivity2)
                    .load(data.thumbnail)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(imageView2)
            }
            binding.apply {
                Glide.with(this@DetailActivity2)
                    .load(data.thumbnail)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .circleCrop()
                    .into(ivProfile)
            }

        }
    }
}