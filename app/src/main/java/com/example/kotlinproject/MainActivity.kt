package com.example.kotlinproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.data.searchResponseData
import com.example.kotlinproject.network.RequestURL
import com.example.kotlinproject.search.SearchAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var rvSearch: RecyclerView
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search.setOnClickListener{
            initSearchList()
            getSearchResponse()
            edt_search_keyword?.text = null
        }
    }

    private fun initSearchList(){
        rvSearch = findViewById(R.id.rv_item_search)

        searchAdapter = SearchAdapter(this)

        rvSearch.adapter = searchAdapter

        rvSearch.layoutManager = LinearLayoutManager(this)

        searchAdapter.notifyDataSetChanged()
    }

    private fun getSearchResponse(){
        val call: Call<searchResponseData> =
            RequestURL.service.getSearchResult(query = edt_search_keyword.text.toString())
        call.enqueue(object : Callback<searchResponseData> {
            override fun onFailure(call: Call<searchResponseData>, t: Throwable) {
                Log.e("getSearchResponse",t.toString())
            }

            override fun onResponse(
                call: Call<searchResponseData>,
                response: Response<searchResponseData>
            ) {
                val serchResult= response.body()?.items
                if (response.isSuccessful) {
                    if(serchResult!=null){
                        searchAdapter.data = serchResult
                        Log.d("명",serchResult.toString())
                    }
                    searchAdapter.notifyDataSetChanged()
                }
            }

        })


    }
}

