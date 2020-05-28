package com.example.kotlinproject.network

import com.example.kotlinproject.data.searchResponseData
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RequestInterface {

    @GET("/v1/search/kin.json")
    fun getSearchResult(
        @Header("X-Naver-Client-Id")clientId:String="CUsno_MHATn82KNlJGbW",
        @Header("X-Naver-Client-Secret")clientSecret:String="jOiHT4f3F1",
        @Query("query")query:String
    ): searchResponseData // call에서 반환 수정
}