package com.example.kotlinproject.data.source

import com.example.kotlinproject.data.SearchResponseData
import com.example.kotlinproject.data.source.remote.SearchRemoteDataSource

class SearchRepository(private val remoteDataSource: SearchRemoteDataSource):SearchDataSourece {

    override suspend fun getSearchInfo(
        clientId: String,
        clientSecret: String,
        query: String,
        onSuccess: (searchResponseData : SearchResponseData) -> Unit,
        onFailure: (errorMsg: String) -> Unit
    ){
        remoteDataSource.getSearchInfo(
            query = query,
            onSuccess = onSuccess,
            onFailure = onFailure
        )
    }
}