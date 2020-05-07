package com.example.kotlinproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.search.SearchAdapter
import com.example.kotlinproject.search.SearchItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvSearch: RecyclerView
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search.setOnClickListener{
            initSearchList()
        }
    }

    private fun initSearchList(){
        rvSearch = findViewById(R.id.rv_item_search)

        searchAdapter = SearchAdapter(this)

        rvSearch.adapter = searchAdapter

        rvSearch.layoutManager = LinearLayoutManager(this)

        searchAdapter.data = listOf(
            SearchItem(
                title = "제목이다아아아아",
                desc = "내용이다아아아아아"
            ),
            SearchItem(
                title = "제목이다아아아아",
                desc = "내용이다아아아아아"
            ),
            SearchItem(
                title = "제목이다아아아아",
                desc = "내용이다아아아아아"
            ),
            SearchItem(
                title = "제목이다아아아아",
                desc = "내용이다아아아아아"
            ),
            SearchItem(
                title = "제목이다아아아아",
                desc = "내용이다아아아아아"
            )
        )

        searchAdapter.notifyDataSetChanged()
    }
}

