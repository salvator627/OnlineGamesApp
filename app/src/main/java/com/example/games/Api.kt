package com.example.games

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("games")
    fun games():Call<ArrayList<PostResponse>>
}