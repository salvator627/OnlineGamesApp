package com.example.games

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private val list = ArrayList<PostResponse>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.recyclerView)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        rv.setBackgroundColor(Color.DKGRAY)


        RetrofitClient.instance.games().enqueue(object:Callback<ArrayList<PostResponse>>{
            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                response.body()?.let { list.addAll(it)}
                val adapter = GameAdapter(list)
                rv.adapter = adapter

                adapter.setOnItemclickcallback(object : GameAdapter.onItemclick{
                    override fun onItemclicked(data: PostResponse) {
                        val intent = Intent(this@MainActivity,DetailActivity2::class.java)
                        intent.putExtra("data",data)
                        startActivity(intent)

                    }

                })
            }

            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {

            }

        })
    }
}