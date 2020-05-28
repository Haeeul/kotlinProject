package com.example.kotlinproject.data.source

import com.example.kotlinproject.data.SearchResponseData

interface SearchDataSourece{
    // 구글공식에 따라 1개로 local과 remote에서 사용.
    suspend fun getSearchInfo(
        //RequestInterface 호출 내용들 기재
        clientId:String="CUsno_MHATn82KNlJGbW",
        clientSecret:String="jOiHT4f3F1",
        query:String,
        onSuccess: (searchResponseData : SearchResponseData) -> Unit,
        onFailure: (errorMsg: String) -> Unit
    )
}