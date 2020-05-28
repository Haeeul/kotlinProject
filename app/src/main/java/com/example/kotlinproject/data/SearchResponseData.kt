package com.example.kotlinproject.data

data class SearchResponseData(
    val total:Int,
    val start:Int,
    val display:Int,
    val items:ArrayList<SearchResponseDataItem>
)

data class SearchResponseDataItem(
    val title:String,
    val link:String,
    val description:String
)