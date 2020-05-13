package com.example.kotlinproject.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestURL {

    //API 주소
    private const val BASE_URL = "https://openapi.naver.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service : RequestInterface = retrofit.create(RequestInterface::class.java)
}