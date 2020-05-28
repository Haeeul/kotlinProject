package com.example.kotlinproject.data.source.remote

import com.example.kotlinproject.data.SearchResponseData
import com.example.kotlinproject.data.source.SearchDataSourece
import com.example.kotlinproject.network.RequestInterface
import retrofit2.Call
import retrofit2.Response

class SearchRemoteDataSource (private  val searchApi:RequestInterface):SearchDataSourece{
    override suspend fun getSearchInfo(
        clientId: String,
        clientSecret: String,
        query: String,
        onSuccess: (searchResponseData: SearchResponseData) -> Unit,
        onFailure: (errorMsg: String) -> Unit
    ) {
        searchApi.getSearchResult(query = query).enqueue(object : retrofit2.Callback<SearchResponseData> {
            override fun onFailure(call: Call<SearchResponseData>, t: Throwable) {
                onFailure(t.toString())
            }

            override fun onResponse(
                call: Call<SearchResponseData>,
                response: Response<SearchResponseData>
            ) {
                when (response.isSuccessful) {
                    true -> response.body()?.let(onSuccess)
                    false -> onFailure(response.errorBody().toString())
                }
            }
        })
    }
}