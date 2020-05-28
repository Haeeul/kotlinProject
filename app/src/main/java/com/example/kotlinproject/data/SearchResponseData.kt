package com.example.kotlinproject.data

data class searchResponseData(
    val total:Int,
    val start:Int,
    val display:Int,
    val items:ArrayList<searchResponseDataItem>
)

data class searchResponseDataItem(
    val title:String,
    val link:String,
    val description:String
)