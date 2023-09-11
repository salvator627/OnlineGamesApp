package com.example.games

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PostResponse(
    val id: Int,
    val title: String,
    val developer: String,
    val thumbnail: String,
    val short_description: String,
    val platform: String,
    val release_date: String,
    val genre: String
):Parcelable